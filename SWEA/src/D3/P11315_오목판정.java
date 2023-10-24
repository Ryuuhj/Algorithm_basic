package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11315_오목판정 {
    static char[][] board;
    static int N, total;
    static int[] dr = {0, 1, 1, 1};
    static int[] dc = {1, 0, 1, -1};

    static int[] cnt;
    static String ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            sb.append("#").append(t + 1).append(" ");
            board = new char[N][N];
            cnt = new int[4];
            ans = "NO";
            for (int i = 0; i < N; i++) {
                board[i] = br.readLine().toCharArray();
            }

            loop1:
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if(board[r][c] == 'o') {
                        for (int i = 0; i < 4; i++) {
                            total = 0;
                            detect(r, c, i);
                            if (total >= 5) {
                                ans = "YES";
                                break loop1;
                            }
                        }
                    }

                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static void detect(int r, int c, int dir) {
        for (int k = 0; k < N; k++) {
            int nr = r + k * dr[dir];
            int nc = c + k * dc[dir];
            if (!(nr < 0 || nr >= N || nc < 0 || nc >= N)) {
                if(board[nr][nc] == 'o')
                    total += 1;
                else
                    return;
            }
            else
                return;
        }
    }
}
