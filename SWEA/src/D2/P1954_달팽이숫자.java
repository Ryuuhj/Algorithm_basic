package D2;

import java.io.*;

public class P1954_달팽이숫자 {
    static int[][] snail;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            getSnail(N);
        }
        System.out.println(sb);
    }

    private static void getSnail(int N) {
        snail = new int[N][N];
        int turn = 0, r = 0, c = 0;
        for (int i = 1; i <= N * N; i++) {

            snail[r][c] = i;
            if (r + dr[turn] < 0 || r + dr[turn] >= N || c + dc[turn] < 0 || c + dc[turn] >= N
                    || snail[r + dr[turn]][c + dc[turn]] != 0) {
                turn = (turn + 1) % 4;
            }
            r += dr[turn];
            c += dc[turn];
        }
        sb.append("#").append(N).append("\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(snail[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return;
    }

}
