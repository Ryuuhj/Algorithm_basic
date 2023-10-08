package DP1;

import java.io.*;

public class P9461_파도반_수열 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[100];
        dp[0] = 1; dp[1] = 1; dp[2] = 1;
        for (int i = 3; i < 100; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            bw.write(dp[N - 1] + "\n");
        }
        bw.close();
    }
}
