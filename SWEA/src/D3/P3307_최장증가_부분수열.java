package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P3307_최장증가_부분수열 {
    static StringTokenizer st;
    static int N;
    static int[] num;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            num = new int[N];
            dp = new int[N];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }
            dp[0] = 1;
            for (int i = 1; i < N; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (num[j] <= num[i] && dp[i] <= dp[j]) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            int max = Arrays.stream(dp).max().getAsInt();
            System.out.printf("#%d %d\n", t + 1, max);
        }
    }
}
