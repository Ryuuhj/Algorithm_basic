package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2001_파리퇴치 {
    static int[][] flies, prefixSum;
    static int N, M, max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            flies = new int[N][N];
            prefixSum = new int[N + 1][N + 1];
            max = 0;

            for (int i = 0; i < N; i++) {
                flies[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    prefixSum[i][j] = flies[i - 1][j - 1] + prefixSum[i][j - 1] + prefixSum[i - 1][j] - prefixSum[i - 1][j - 1];
                }
            }

            System.out.printf("#%d %d\n", t, max);
        }
    }

    private static void getMax(int r, int c) {
        int sum = 0;
        for (int i = r; i < r + M; i++) {
            for (int j = c; j < c + M; j++) {
                sum += flies[i][j];
            }
        }
        max = Math.max(max, sum);
    }
}
