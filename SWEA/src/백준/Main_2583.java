package 백준;

import java.util.*;

public class Main_2583 {
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int M, N, K, sx, sy, ex, ey;
    static boolean[][] board;
    static ArrayList<Integer> area;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();
        board = new boolean[N][M];
        area = new ArrayList<>();
        while (K-- > 0) {
            sx = sc.nextInt();
            sy = sc.nextInt();
            ex = sc.nextInt();
            ey = sc.nextInt();
            for (int i = sx; i < ex; i++) {
                for (int j = sy; j < ey; j++) {
                    board[i][j] = true;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!board[i][j]) {
                    cnt++;
                    area.add(bfs(i, j));
                }
            }
        }
        Collections.sort(area);
        sb.append(cnt).append("\n");
        for (int n : area) {
            sb.append(n).append(" ");
        }
        System.out.println(sb);
    }

    private static int bfs(int i, int j) {
        Queue<Pos> queue = new LinkedList<>();
        int area = 0;
        queue.add(new Pos(i, j));
        board[i][j] = true;
        while (!queue.isEmpty()) {
            Pos now = queue.poll();
            area++;
            for (int k = 0; k < 4; k++) {
                int nx = now.x + dx[k];
                int ny = now.y + dy[k];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M || board[nx][ny]) continue;
                board[nx][ny] = true;
                queue.add(new Pos(nx, ny));
            }
        }
        return area;
    }

    private static class Pos{
        int x, y;
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
