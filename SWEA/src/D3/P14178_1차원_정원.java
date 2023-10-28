package D3;

import java.util.Scanner;

public class P14178_1차원_정원 {
    static int N, D, unit, cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            N = sc.nextInt();
            D = sc.nextInt();
            unit = 2 * D + 1;
            cnt = (N % unit == 0) ? N / unit : (N / unit) +1;
            System.out.printf("#%d %d\n",t+1, cnt);
        }
    }
}
