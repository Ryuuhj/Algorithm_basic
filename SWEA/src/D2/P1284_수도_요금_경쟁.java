package D2;

import java.util.Scanner;

public class P1284_수도_요금_경쟁 {
    static int P, Q, R, S, W, chargeA, chargeB;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int k = 1; k <= T; k++) {
            P = sc.nextInt(); Q = sc.nextInt(); R = sc.nextInt(); S = sc.nextInt(); W = sc.nextInt();
            chargeA = W * P;
            chargeB = W <= R ? Q : Q + (W - R) * S;
            System.out.printf("#%d %d\n", k, Math.min(chargeA, chargeB));
        }
    }
}
