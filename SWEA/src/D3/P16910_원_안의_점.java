package D3;

import java.util.Scanner;

public class P16910_원_안의_점 {
    static int N, cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            cnt = 0;
            for (int x = -N+1; x < N; x++) {
                for (int y = -N+1; y <N ; y++) {
                    if(isInside(x, y))
                        cnt++;
                }
            }
            System.out.printf("#%d %d\n", t, cnt+4);
        }
    }

    private static boolean isInside(int x, int y) {
        return (Math.pow(x, 2) + Math.pow(y, 2)) <= Math.pow(N,2);
    }
}
