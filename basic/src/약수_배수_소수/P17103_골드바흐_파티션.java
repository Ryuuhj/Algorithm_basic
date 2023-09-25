package 약수_배수_소수;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P17103_골드바흐_파티션 {
    final static int NUM = 1000001;
    static int T, N, cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] isPrime = new boolean[NUM + 1];
        Arrays.fill(isPrime, 2, NUM + 1, true);

        for (int i = 2; i <= NUM; i++) {
            if (isPrime[i]) {
                for (int j = i * 2; j <= NUM; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            cnt = 0;
            for (int i = 2; i <= N / 2; i++) {
                if (isPrime[i] && isPrime[N - i])
                    cnt++;
            }
            bw.write(cnt + "\n");
        }
        bw.close();
    }
}
