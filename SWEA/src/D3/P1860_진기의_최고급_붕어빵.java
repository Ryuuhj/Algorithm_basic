package D3;

import java.util.Arrays;
import java.util.Scanner;

public class P1860_진기의_최고급_붕어빵 {
    static int N, M, K;
    static int[] arrTime;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            N = sc.nextInt();
            M = sc.nextInt();
            K = sc.nextInt();

            arrTime = new int[N+1];
            for (int i = 1; i <= N; i++) {
                arrTime[i] = sc.nextInt();
            }
            Arrays.sort(arrTime);

            String ans = "Possible";
            for (int i = 1; i <= N; i++) {
                int now = (arrTime[i] / M) * K;
                if (i > now) {
                    ans = "Impossible";
                    break;
                }
            }
            System.out.printf("#%d %s\n", t + 1, ans);

        }
    }
}
