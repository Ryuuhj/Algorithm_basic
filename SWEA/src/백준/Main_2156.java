package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2156 {
    static int N;
    static int[][] dp;
    static int[] wine;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        wine = new int[N];
        for (int i = 0; i < N; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }
        dp = new int[3][N];
        dp[1][0] = dp[2][0] = wine[0];
        for (int i = 1; i < N; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], Math.max(dp[1][i - 1], dp[2][i - 1]));
            dp[1][i] = dp[0][i - 1] + wine[i];
            dp[2][i] = dp[1][i - 1] + wine[i];
        }
        int max = Math.max(dp[2][N - 1], (Math.max(dp[0][N - 1], dp[1][N - 1])));
        System.out.println(max);
    }
}
