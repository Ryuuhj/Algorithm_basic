package D3;

import java.util.Scanner;

public class Solution_8016 {
    static int T;
    static long N, left, right;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextLong();
            if (N == 1) {
                left = right = 1;
            }else {
                right = (N * N) * 2 - 1; //Math.pow-> double형이라 범위 초과
                left = (N - 1) * (N - 1) * 2 + 1;
            }
            System.out.println("#" + t + " " + left + " " + right);
        }
    }
}
