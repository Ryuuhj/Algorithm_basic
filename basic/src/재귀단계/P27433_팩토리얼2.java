package 재귀단계;

import java.util.Scanner;

public class P27433_팩토리얼2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(factorial(sc.nextInt()));
    }

    private static long factorial(int n) {
        if(n == 0)
            return 1;
        return n * factorial(n - 1);
    }
}
