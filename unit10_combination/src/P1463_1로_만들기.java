import java.util.Scanner;

public class P1463_1로_만들기 {
    static int N;
    static int[] dp = new int[1000001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp[0] = -1;
        for (int i = 1; i <= N; i++) {
            dp[i] = 1 + dp[i - 1];
            if (i % 3 == 0)
                dp[i] = Math.min(1 + dp[i / 3], dp[i]);
            if (i % 2 == 0)
                dp[i] = Math.min(1 + dp[i / 2], dp[i]);
        }
        System.out.println(dp[N]);
    }
}
