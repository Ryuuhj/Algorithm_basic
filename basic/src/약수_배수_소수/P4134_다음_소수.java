package 약수_배수_소수;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P4134_다음_소수 {
    static long T, n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Long.parseLong(br.readLine());
        while (T-- > 0) {
            n = Long.parseLong(br.readLine());
            if (n == 0 || n == 1) {
                bw.write(2 + "\n");
                continue;
            }
            while (!isPrime(n)) {
                n++;
            }
            bw.write(n + "\n");
        }
        bw.close();
    }

    private static boolean isPrime(long n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
