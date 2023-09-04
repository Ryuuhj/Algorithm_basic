import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2162_선분그룹 {
    static StringTokenizer st;
    static int N;
    static int[] parent;
    static int[][] line;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int groupCnt = 0;
        int maxSize = 0;
        N = Integer.parseInt(bf.readLine());
        parent = new int[N + 1];
        line = new int[N + 1][4]; //0,1 = 시작점 / 2,3 = 끝점
        Arrays.fill(parent, -1);

        //선 저장 겸 그룹화
        for (int i = 1; i < line.length; i++) {
            st = new StringTokenizer(bf.readLine());
            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
            line[i][2] = Integer.parseInt(st.nextToken());
            line[i][3] = Integer.parseInt(st.nextToken());
            for (int j = 1; j < i; j++) {
                //교차하는 경우
                if (isCrossed(line[i][0], line[i][1], line[i][2], line[i][3], line[j][0], line[j][1], line[j][2], line[j][3]))
                    union(i, j);
            }
        }
        //답변 출력
        for (int i = 1; i <= N; i++) {
            if (parent[i] < 0) { //그룹 대표인 경우
                groupCnt++;
                maxSize = Math.min(maxSize, parent[i]);
            }
        }
        System.out.println(groupCnt);
        System.out.println(Math.abs(maxSize));

    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != -1 && rootA == rootB) {//이미 같은 그룹인 경우
            return;
        }
        //아닐 경우 합병
        parent[rootA] += parent[rootB];
        parent[rootB] = rootA;
    }

    private static int find(int a) {
        if (parent[a] < 0) //부모 노드인 경우
            return a;
        return parent[a] = find(parent[a]);
    }

    private static boolean isCrossed(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        int ccw1 = ccw(x1, y1, x2, y2, x3, y3) * ccw(x1, y1, x2, y2, x4, y4);
        int ccw2 = ccw(x3, y3, x4, y4, x1, y1) * ccw(x3, y3, x4, y4, x2, y2);

        if (ccw1 == 0 && ccw2 == 0) {
            return isOverlapped(x1, y1, x2, y2, x3, y3, x4, y4);//겹치는 경우 -> 같은 그룹
        } else if (ccw1 <= 0 && ccw2 <= 0) {
            return true;
        } else
            return false;
    }

    private static boolean isOverlapped(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        if (Math.min(x3, x4) <= Math.max(x1, x2) && Math.min(x1, x2) <= Math.max(x3, x4) &&
                Math.min(y3, y4) <= Math.max(y1, y2) && Math.min(y1, y2) <= Math.max(y3, y4)) {
            return true;
        }
        return false;
    }

    private static int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
        long result = (x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * y2 + x1 * y3);
        if (result > 0)
            return 1; //반시계 방향
        else if (result == 0) {
            return 0;
        } else
            return -1; //시계
    }
}
