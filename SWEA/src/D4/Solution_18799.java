package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_18799 {
    static int n;
    static long sum;
    static int[] S;
    static int[][] com = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        setComb();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            n = Integer.parseInt(br.readLine());
            S = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            sum = Arrays.stream(S).sum();
            double avg = getAvgSum(n, sum) / (Math.pow(2, n) - 1);

            if(Math.floor(avg) == avg)
                sb.append((int) avg).append("\n");
            else
                sb.append(avg).append("\n");
        }
        System.out.print(sb);
    }

    private static double getAvgSum(int n, double sum) {
        double total = sum;
        for (int i = 2; i <= n; i++) {
            if (i == n) {
                total += (sum / n);
                continue;
            }
            total += (sum * (com[n][i] - com[n - 1][i]))/i;
        }
        return total;
    }

    private static void setComb() {
        for (int i = 0; i < 9; i++) {
            Arrays.fill(com[i], 1);
        }
        for (int i = 2; i < 9; i++) {
            for (int j = 1; j < i; j++) {
                com[i][j] = com[i - 1][j - 1] + com[i - 1][j];
            }
        }
    }
}
