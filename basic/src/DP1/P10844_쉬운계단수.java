package DP1;

import java.util.Arrays;
import java.util.Scanner;

public class P10844_쉬운계단수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[][] dp = new long[N + 1][10];

        dp[1] = new long[]{0, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        //n=1인 경우 예외처리
        if (N < 2) {
            System.out.println(9);
            System.exit(0);
        }

        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][9] = dp[i - 1][8];
            for (int j = 1; j < 9; j++) {
                dp[i][j] += (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
            }
        }
        long ans = Arrays.stream(dp[N]).sum() % 1000000000;
        System.out.println(ans);
    }
}
