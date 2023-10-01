package 재귀단계;

import java.util.Scanner;

public class P10870_피보나치5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 1) {
            System.out.println(n);
            return;
        }
        System.out.println(fibo(n));
    }

    private static int fibo(int n) {
        if(n == 0)
            return 0;
        else if (n == 1)
            return 1;
        return fibo(n - 1) + fibo(n - 2);

    }
}
