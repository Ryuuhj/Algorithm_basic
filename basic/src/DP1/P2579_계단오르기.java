package DP1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2579_계단오르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] stair = new int[n + 2];
        int[][] dp = new int[n + 1][2];
        int val = 0;

        for (int i = 1; i <= n; i++) {
            stair[i] = Integer.parseInt(bf.readLine());
        }
        if (n <= 1) {
            System.out.println(stair[1]);
            System.exit(0);
        }

        dp[1][0] = 0; dp[1][1] = stair[1];

        for (int k = 2; k <= n; k++) {
            dp[k][1] = Math.max(dp[k - 2][0] + stair[k - 1], dp[k - 2][1]) + stair[k];
            dp[k][0] = dp[k - 1][1];
        }

        System.out.println(dp[n][1]);

    }
}
