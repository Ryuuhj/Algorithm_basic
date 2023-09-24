package 약수_배수_소수;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P4948_베르트랑_공준 {
    final static int k = 123456 * 2;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] isPrime = new boolean[k + 1];
        Arrays.fill(isPrime, 2, isPrime.length, true);

        for (int i = 2; i <= Math.sqrt(k); i++) {
            if (isPrime[i]) {
                for (int j = i * 2; j <= k; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int n = Integer.parseInt(br.readLine()), cnt = 0;

        while (n != 0) {
            cnt = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (isPrime[i])
                    cnt++;
            }
            bw.write(cnt + "\n");
            n = Integer.parseInt(br.readLine());
        }
        bw.close();
    }
}
