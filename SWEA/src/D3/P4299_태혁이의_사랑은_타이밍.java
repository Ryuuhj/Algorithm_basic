package D3;

import java.util.Scanner;

public class P4299_태혁이의_사랑은_타이밍 {
    static int D, H, M, sum;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            D = sc.nextInt();
            H = sc.nextInt();
            M = sc.nextInt();
            D = (D - 11) * 60 * 24;
            H = (H - 11) * 60;
            M = M - 11;
            sum = D + M + H;
            if(sum < 0)
                sum = -1;
            System.out.printf("#%d %d\n", t, sum);
        }
    }
}
