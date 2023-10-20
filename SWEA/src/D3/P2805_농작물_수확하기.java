package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2805_농작물_수확하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] farm = new int[N][N];
            int revenue = 0;
            for (int i = 0; i < N; i++) {
                farm[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            }
            for (int i = 0; i < N/2; i++) {
                int row = N-1-i;
                for (int j = N/2 - i; j <= N / 2 + i; j++) {
                    revenue += (farm[i][j] + farm[row][j]);
                }
            }
            revenue += Arrays.stream(farm[N / 2]).sum();
            System.out.printf("#%d %d\n", t, revenue);

        }
    }
}
