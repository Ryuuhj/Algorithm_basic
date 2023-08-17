import java.util.Scanner;

public class P2193_이친수 {
    static int N;
    static long[][] pn;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        pn = new long[91][2];
        pn[1][1] = 1;
        pn[2][0] = 1;
        if (N <= 2) {

        } else {
            for (int i = 3; i <= N; i++) {
                pn[i][0] = pn[i - 1][0] + pn[i - 1][1];
                pn[i][1] = pn[i - 1][0];
            }
        }
        System.out.println(pn[N][0] + pn[N][1]);
    }
}
