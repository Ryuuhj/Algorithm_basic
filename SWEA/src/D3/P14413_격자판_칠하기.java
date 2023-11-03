package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14413_격자판_칠하기 {
    static String[][] board;
    static boolean flag;
    static int N, M;
    static String ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            board = new String[N][M];
            flag = false;
            for (int i = 0; i < N; i++) {
                board[i] = br.readLine().split("");
            }
            checkPossible("#", ".");
            if (!flag) {
                checkPossible(".", "#");
            }
            if(flag)
                ans = "possible";
            else
                ans = "impossible";
            System.out.printf("#%d %s\n", t, ans);
        }
    }

    private static void checkPossible(String s1, String s2) {
        String odd, even;
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                even = s1;
                odd = s2;
            } else {
                even = s2;
                odd = s1;
            }
            for (int j = 0; j < M; j++) {
                if (j % 2 == 0) {
                    if (board[i][j].equals(odd))
                        return;
                } else {
                    if (board[i][j].equals(even))
                        return;
                }
            }
        }
        flag = true;
    }
}
