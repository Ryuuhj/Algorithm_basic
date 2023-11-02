package D3;

import java.util.Arrays;
import java.util.Scanner;

public class P4466_최대_성적표_만들기 {
    static int N, K;
    static int[] score;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            K = sc.nextInt();
            score = new int[N];
            for (int i = 0; i < N; i++) {
                score[i] = sc.nextInt();
            }
            Arrays.sort(score);
            int sum = 0;
            for (int i = N - K; i < N; i++) {
                sum += score[i];
            }
            System.out.printf("#%d %d\n", t, sum);
        }
    }
}
