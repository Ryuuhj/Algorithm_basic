package 약수_배수_소수;

import java.util.Arrays;
import java.util.Scanner;

public class P2581_소수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;

        for (int i = 2; i < Math.sqrt(N); i++) {
            if (isPrime[i]) {
                for (int j = i * 2; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int sum = 0, min = 0;
        for (int i = M; i <= N; i++) {
            if (isPrime[i]) {
                sum += i;
                if (min == 0) {
                    min = i;
                }

            }
        }
        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
