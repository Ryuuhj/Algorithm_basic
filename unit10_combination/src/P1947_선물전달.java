import java.util.Scanner;

public class P1947_선물전달 {
    static int N;
    static final long MOD = 1000000000;
    static long[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        dp = new long[1000001];
        //dp 초기화
        dp[1] = 0;
        dp[2] = 1;
        N = sc.nextInt();
        for (int i = 3; i <= N; i++) {
            dp[i] = (i - 1) * (dp[i - 2] + dp[i - 1]) % MOD;
        }
        System.out.println(dp[N]);
    }

}
