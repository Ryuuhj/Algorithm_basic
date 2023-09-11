package 일반수학1;

import java.util.Scanner;

public class P2903_중앙이동_알고리즘 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] dp = new long[N + 1];
        dp[0] = 4;
        //dp[1] = 9;
        for (int i = 1; i <= N; i++) {
            dp[i] = (long) (dp[i - 1] + 5 * Math.pow(4, i - 1) - Math.pow(2, i - 1) * (Math.pow(2, i) - 2));
        }
        System.out.println(dp[N]);
    }
}
