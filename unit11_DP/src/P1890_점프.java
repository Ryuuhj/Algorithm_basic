import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1890_점프 {
    static StringTokenizer st;
    static int n;
    static int[][] distance;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        distance = new int[n][n];
        dp = new long[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j <n ; j++) {
                distance[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;
        //dfs(0, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int k = distance[i][j];
                if(k == 0)
                    continue;
                //가능한 방향 탐색 및 갱신 -> 갱신지점 다시 탐색 시작
                if (j + k < n) {
                    dp[i][j + k] += dp[i][j];
                }
                if (i + k < n) {
                    dp[i + k][j] += dp[i][j];
                }
            }
        }

        System.out.println(dp[n - 1][n - 1]);
    }

    private static void dfs(int i, int j) {
        if(distance[i][j] == 0)
            return;
        //가능한 방향 탐색 및 갱신 -> 갱신지점 다시 탐색 시작
        int k = distance[i][j];
        if (j + k < n) {
            dp[i][j + k] += dp[i][j];
            dfs(i, j + k);
        }
        if (i + k < n) {
            dp[i + k][j] += dp[i][j];
            dfs(i + k, j);
        }
        //두 경우 해당 안되면 종료
        return;
    }
}
