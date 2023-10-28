package D3;

import java.util.Arrays;

public class P3131_100만이하의_모든_소수 {
    static final int N = 1000000;
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, 2, N + 1, true);
        for (int i = 0; i <= Math.sqrt(N); i++) {
            if (isPrime[i]) {
                for (int j = 2 * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 0; i <= N; i++) {
            if (isPrime[i])
                sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
