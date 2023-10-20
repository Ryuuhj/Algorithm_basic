package D3;

import java.util.Scanner;

public class P1491_원재의_벽꾸미기 {
    static long N, A, B;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextLong();
            A = sc.nextLong();
            B = sc.nextLong();
            long min = Long.MAX_VALUE;
            //i == j인 경우
            if (Math.sqrt(N) == (long) Math.sqrt(N)) {
                min = 0;
            }
            //i <= j라 가정, i*j = N이어야 함
            for (int i = 1; i <= Math.sqrt(N); i++) {
                for (int j = i; j <= N/i; j++) {
                    min = Math.min(min, getMin(j, i));
                }
            }
            System.out.printf("#%d %d\n",t,min);
        }
    }
    private static long getMin(int r, int c) {
        return A * (r - c) + B * (N - (long) r * c);
    }
}
