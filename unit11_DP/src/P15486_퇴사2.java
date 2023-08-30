import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15486_퇴사2 {
    static StringTokenizer st;
    static int N;
    static long[] dp;
    static int[][] table;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        dp = new long[N + 2];
        table = new int[N + 1][2];
        long max = 0;

        for (int i = 1; i < table.length; i++) {
            st = new StringTokenizer(bf.readLine());
            table[i][0] = Integer.parseInt(st.nextToken());
            table[i][1] = Integer.parseInt(st.nextToken());
        }
        //뒤에서부터 dp 진행
        for (int i = N; i > 0; i--) {
            if (i + table[i][0] > N + 1)
                dp[i] = dp[i + 1];
            else {
                dp[i] = Math.max(dp[i + 1], dp[i + table[i][0]] + table[i][1]);
                max = Math.max(max, dp[i]);
            }
        }

        System.out.println(max);
    }

}
