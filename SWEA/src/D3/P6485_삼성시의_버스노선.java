package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P6485_삼성시의_버스노선 {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] cnt;
    static int[][] route;
    static int N, P, j, A, B;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");
            N = Integer.parseInt(br.readLine());
            cnt = new int[5001];
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                A = Integer.parseInt(st.nextToken());
                B = Integer.parseInt(st.nextToken());
                for (int k = A; k <= B; k++) {
                    cnt[k]++;
                }
            }
            P = Integer.parseInt(br.readLine());
            while (P-- > 0) {
                j = Integer.parseInt(br.readLine());
                sb.append(cnt[j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
