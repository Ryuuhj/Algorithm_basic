package 약수_배수_소수;

import java.util.Arrays;
import java.util.Scanner;

public class P1978_소수찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] isPrime = setPrimeNumber(1000);
        int N = sc.nextInt();
        int num = 0, cnt = 0;
        while (N-- > 0) {
            num = sc.nextInt();
            if (isPrime[num])
                cnt++;
        }
        System.out.println(cnt);
    }

    private static boolean[] setPrimeNumber(int n) {
        boolean[] p = new boolean[n + 1];
        Arrays.fill(p, 2, n+1, true);

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (p[i]) { //i가 소수면 i 제외하고 나머지 배수 처리
                for (int j = i * 2; j <= n; j += i) {
                    p[j] = false;
                }
            }
        }
        return p;
    }
}
