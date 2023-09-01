import java.util.Scanner;

public class P9095_123더하기 {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] dp = new int[11];
        dp[1] = 1; dp[2] = 2; dp[3] = 4;
        for (int i = 4; i < dp.length; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }
        while (T-- > 0) {
            n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}
