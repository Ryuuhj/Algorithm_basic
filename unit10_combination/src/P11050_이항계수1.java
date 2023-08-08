import java.util.Scanner;

public class P11050_이항계수1 {
    static int N, K;
    static int[][] D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        setArray();
        if (K > N / 2)
            K = N - K;
        //점화식으로 조합 구해 출력
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                D[i][j] = D[i - 1][j] + D[i - 1][j - 1];
                if (i == N && j == K) {
                    System.out.println(D[i][j]);
                    return;
                }
            }
        }
        System.out.println(D[N][K]);
    }

    private static void setArray() {
        D = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            D[i][0] = 1;
            D[i][1] = i;
            D[i][i] = 1;
        }
    }
}
