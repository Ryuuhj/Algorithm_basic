import java.util.Arrays;
import java.util.Scanner;

public class P10844_쉬운계단수 {
    static int n;
    static final long MOD = 1000000000;
    static long[][] dp = new long[101][10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Arrays.fill(dp[1], 1);
        dp[1][0] = 0;

        if (n >= 2) {
            for (int i = 2; i <= n; i++) {
                dp[i][0] = dp[i - 1][1];
                dp[i][9] = dp[i - 1][8];
                for (int j = 1; j <= 8; j++) {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
                }
            }
        }
        long result = 0;
        for (long num: dp[n]) {
            result = (result + num) % MOD;
        }
        System.out.println(result);
    }
}
