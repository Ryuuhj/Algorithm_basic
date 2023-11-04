package D2;

import java.util.Scanner;

public class P1976_시각덧셈 {
    static int h1, h2, m1, m2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            h1 = sc.nextInt();
            m1 = sc.nextInt();
            h2 = sc.nextInt();
            m2 = sc.nextInt();
            h1 += h2; m1 += m2;
            h1 += (m1 / 60);
            h1 = h1 / 13 + h1 % 13;
            m1 %= 60;
            System.out.printf("#%d %d %d\n", t, h1, m1);
        }
    }
}
