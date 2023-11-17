package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_3304 {
    static int T;
    static String[] input;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            input = br.readLine().split(" ");
            int len1 = input[0].length(), len2 = input[1].length();
            dp = new int[len1 + 1][len2 + 1];
            for (int i = 1; i <= len1; i++) {
                for (int j = 1; j <= len2; j++) {
                    if (input[0].charAt(i-1) == input[1].charAt(j-1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            System.out.printf("#%d %d\n", t, dp[len1][len2]);
        }
    }
}
