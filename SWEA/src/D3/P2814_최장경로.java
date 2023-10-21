package D3;

import java.util.ArrayList;
import java.util.Scanner;

public class P2814_최장경로 {
    static ArrayList<Integer>[] edge;
    static int N, M;
    static int max;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            M = sc.nextInt();
            edge = new ArrayList[N + 1];
            visited = new boolean[N + 1];
            for (int i = 0; i <= N; i++) {
                edge[i] = new ArrayList<Integer>();
            }
            //0으로 시작하는 모든 방향
            for (int i = 1; i <= N ; i++) {
                edge[0].add(i);
            }
            for (int i = 0; i < M; i++) {
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                edge[v1].add(v2);
                edge[v2].add(v1);
            }
            max = Integer.MIN_VALUE;
            dfs(0, 0);
            System.out.printf("#%d %d\n", t, max);
        }
    }

    private static void dfs(int depth, int pre) {
        for (int i = 0; i < edge[pre].size(); i++) {
            int n = edge[pre].get(i);
            if (!visited[n]) {
                visited[n] = true;
                dfs(depth + 1, n);
                visited[n] = false;
            }
        }
        //모든 노드를 방문했을 경우
        max = Math.max(max, depth);
        return;
    }
}
