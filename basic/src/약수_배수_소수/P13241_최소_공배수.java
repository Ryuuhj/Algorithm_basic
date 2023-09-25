package 약수_배수_소수;

import java.util.Scanner;

public class P13241_최소_공배수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();

        long gcd = GCD(Math.max(A, B), Math.min(A, B));

        System.out.println(A * B / gcd);
    }

    private static long GCD(long max, long min) {
        if (max % min == 0) {
            return min;
        }
        return GCD(min, max % min);
    }
}
