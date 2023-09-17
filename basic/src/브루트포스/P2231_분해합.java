package 브루트포스;

import java.util.Arrays;
import java.util.Scanner;

public class P2231_분해합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ans = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            if (getDS(i) == N) {
                ans = i;
                break;
            }
        }

        System.out.println(ans);

    }

    private static int getDS(int i) {
        String[] tmp = String.valueOf(i).split("");
        int sum = Arrays.stream(tmp).mapToInt(Integer::parseInt).sum();
        return sum + i;
    }
}
