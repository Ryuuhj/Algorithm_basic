package D3;

import java.util.Scanner;

public class P3431_준환이의_운동관리 {
    static int leftTime, L, U, X;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            L = sc.nextInt(); U = sc.nextInt(); X = sc.nextInt();
            leftTime = -1;
            if(X < L)
                leftTime = L - X;
            else if (X <= U)
                leftTime = 0;
            System.out.printf("#%d %d\n", t, leftTime);
        }
    }
}
