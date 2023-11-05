package D2;

import java.util.Scanner;

public class P1970_쉬운_거스름돈 {
    static final int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + "\n");
            N = sc.nextInt();
            int cnt = 0;
            for (int i = 0; i < unit.length; i++) {
                sb.append(N / unit[i]).append(" ");
                N %= unit[i];
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
