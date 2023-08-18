import java.util.Scanner;

public class P11726_2xn타일링 {
    static int n;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[1001];
        dp[2] = 2;
        dp[1] = 1;
        if (n > 2) {
            for (int i = 2; i <= n; i++) {
                dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
            }
        }
        System.out.println(dp[n]);
    }
}
