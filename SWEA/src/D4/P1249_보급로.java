package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class P1249_보급로 {
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int[][] field;
    static boolean[][] visited;
    static int N, nx, ny, nTime, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int k = 1; k <= T; k++) {
            N = Integer.parseInt(br.readLine());
            field = new int[N][N];
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                field[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            }
            min = Integer.MAX_VALUE;
            bfs(0, 0);
            System.out.printf("#%d %d\n", k, min);
        }
    }

    private static void bfs(int sx, int sy) {
        PriorityQueue<Point> pq = new PriorityQueue<>();

        pq.add(new Point(sx, sy, 0));
        visited[sx][sy] = true;

        while (!pq.isEmpty()) {
            Point p = pq.poll();

            if (p.x == N - 1 && p.y == N - 1)
                min = Math.min(min, p.minTime); //도착지까지 가는 여러가지 경우의 수 중 최소

            for (int i = 0; i < 4; i++) {
                nx = p.x + dx[i];
                ny = p.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    nTime = p.minTime + field[nx][ny];
                    pq.add(new Point(nx, ny, nTime));
                }
            }
        }
    }

    private static class Point implements Comparable<Point> {
        Point(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.minTime = t;
        }

        int x;
        int y;
        int minTime;

        @Override
        public int compareTo(Point o) {
            if(this.minTime > o.minTime)
                return 1;
            else
                return -1;
        }
    }
}
