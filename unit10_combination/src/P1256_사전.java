import java.util.Scanner;

public class P1256_사전 {
    static int N, M, K;
    static final int INF = 1000000001;
    static int[][] D = new int[201][201];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //조합 배열 먼저 완성
        for (int i = 0; i <= 200; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    D[i][j] = 1;
                } else {
                    D[i][j] = D[i - 1][j] + D[i - 1][j - 1];
                    if (D[i][j] > INF - 1)
                        D[i][j] = INF;
                }
            }
        }
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        //az 개수 카운팅 할 배열 생성
        int[] AZ = new int[2];
        AZ[0] = N;
        AZ[1] = M;

        StringBuilder ans = new StringBuilder();
        if (D[N + M][N] < K) {
            System.out.println(-1);
            return;
        }
        while (AZ[0] != 0 && AZ[1] != 0) {
            //먼저 빈칸에 a라고 가정, 뒷자리 문자 경우의 수로 판별
            int a = AZ[0] - 1;
            int z = AZ[1];
            //남은 수 조합 경우의 수가 K보다 큰 경우 패스 후 a 기록
            if (D[a + z][a] >= K) {
                AZ[0] = a;
                ans.append('a');
            } else {
                K -= D[a + z][a];
                AZ[1] -= 1;
                ans.append('z');
            }
        }
        //이후 남은 문자 복붙
        if (AZ[0] != 0) {
            for (int i = 0; i < AZ[0]; i++) {
                ans.append('a');
            }
        } else if (AZ[1] != 0) {
            for (int i = 0; i < AZ[1]; i++) {
                ans.append('z');
            }
        }
        System.out.println(ans);
    }

}
