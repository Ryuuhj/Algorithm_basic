package DP1;

import java.util.Scanner;

public class P24416_피보나치수1 {
    static int n;
    static int cnt1 = 0, cnt2 = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        fib(n);
        System.out.println(cnt1 + " " + (n - 2));
    }

    private static long fib(int n) {
        if (n == 1 || n == 2) {
            cnt1++;
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
