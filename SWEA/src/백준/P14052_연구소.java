package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P14052_연구소 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map, cMap;
    static int N, M, max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(i, j, 1);
                    map[i][j] = 0;
                }
            }
        }
        System.out.println(max);
    }

    private static void dfs(int x, int y, int cnt) {
        if (cnt == 3) {
            spread();
            return;
        }
        for (int i = x; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(i, j, cnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void spread() {
        Queue<Point> queue = new LinkedList<Point>();
        cMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 2)
                    queue.add(new Point(i, j));
                cMap[i][j] = map[i][j];
            }
        }

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];
                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
                    if (cMap[nextX][nextY] == 0) {
                        cMap[nextX][nextY] = 2;
                        queue.add(new Point(nextX, nextY));
                    }
                }
            }
        }
        calSafeZone(cMap);
    }
    private static void calSafeZone(int[][] cMap) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(cMap[i][j] == 0)
                    cnt++;
            }
        }
        max = Math.max(max, cnt);
    }
    private static class Point{
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
