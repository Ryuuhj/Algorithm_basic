import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13251_조약돌꺼내기 {
    static int M, K, N;
    static double p;
    static int[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(bf.readLine());
        N = 0;
        v = new int[M];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < M; i++) {
            int r = Integer.parseInt(st.nextToken());
            v[i] = r;
            N += r;
        }
        K = Integer.parseInt(bf.readLine());
        double ans = 0;

        if (M == 1) {
            ans = 1.0;
        } else if (K == 1) {
            ans = 1.0;
        }else {
            for (int i = 0; i < v.length; i++) {
                p = 1;
                if (v[i] >= K) {
                    for (int j = 0; j < K; j++) {
                        p *= (double) (v[i] - j) / (N - j);
                    }
                }else {
                    p = 0;
                }
                ans += p;
            }
        }
        System.out.println(ans);
    }
}
