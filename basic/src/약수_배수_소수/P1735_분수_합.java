package 약수_배수_소수;

import java.util.Scanner;

public class P1735_분수_합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A1 = sc.nextInt();
        int B1 = sc.nextInt();
        int A2 = sc.nextInt();
        int B2 = sc.nextInt();

        int p = A1 * B2 + A2 * B1;
        int q = B1 * B2;

        //최소 공약수로 한번 더 나눠줌
        System.out.println((p / GCD(q, p)) + " " + (q / GCD(q, p)));

    }

    private static int GCD(int max, int min) {
        if(max % min == 0)
            return min;
        return GCD(min, max % min);
    }
}
