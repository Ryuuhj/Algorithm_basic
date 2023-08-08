import java.io.BufferedReader;
import java.util.Scanner;

public class P11051_이항계수2 {
    static int N, K;
    static int[][] D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        setArray();
        //K값 수정
        K = Math.min(N - K, K);

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                D[i][j] = (D[i - 1][j] + D[i - 1][j-1]) % 10007;
            }
        }
        //출력
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
