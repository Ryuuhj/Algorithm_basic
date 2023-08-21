import java.util.Scanner;


public class P1915_가장_큰_정사각형 {
    static int n, m;
    static int[][] D;

    static char[] input;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        D = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            input = sc.next().toCharArray();
            for (int j = 1; j <= m; j++) {
                D[i][j] = input[j - 1] - 48;
            }
        }
        //점화식으로 값 갱신
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (D[i][j] == 1) {
                    D[i][j] = Math.min(D[i - 1][j - 1], Math.min(D[i - 1][j], D[i][j - 1])) + 1;
                    max = Math.max(max, D[i][j]);
                } else {
                    D[i][j] = 0;
                }
            }
        }
        System.out.println(max * max);
    }
}
