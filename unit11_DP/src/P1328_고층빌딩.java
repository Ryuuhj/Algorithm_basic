import java.util.Scanner;

public class P1328_고층빌딩 {
    static final long MOD = 1000000007;
    static int N, L, R;
    static long[][][] D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();
        D = new long[N + 1][N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            D[i][i][1] = 1;
            D[i][1][i] = 1;
        }
        //점화식을 통한 값 도출
        for (int n = 2; n <= N; n++) {
            for (int l = 1; l <= n; l++) {
                for (int r = n; r >= 1; r--) {
                    D[n][l][r] = (D[n - 1][l - 1][r] + D[n - 1][l][r - 1] + (n - 2) * D[n - 1][l][r]) % MOD;
                }
            }
        }
        System.out.println(D[N][L][R]);
    }
}

