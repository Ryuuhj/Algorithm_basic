package D3;

import java.util.Scanner;

public class Solution_10726 {
    static int T, N, M;
    static String binary;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            M = sc.nextInt();
            binary = M == 0 ? "OFF" : "ON";
            while (N-- > 0) {
                if (M % 2 != 1) {
                    binary = "OFF";
                    break;
                }
                M /= 2;
            }
            System.out.printf("#%d %s\n", tc, binary);
        }
    }
}
