import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11049_행렬곱셈순서 {
    static StringTokenizer st;
    static int N;
    static int[][] dp;
    static Matrix[] input;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        input = new Matrix[N + 1];
        dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            input[i] = new Matrix(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int answer = cntCal(1, N);
        System.out.println(answer);
    }

    private static int cntCal(int s, int e) {
        int min = Integer.MAX_VALUE;
        if (dp[s][e] != -1) // dp[s][e] 값을 이미 구한 경우
            return dp[s][e];
        if (s == e) //dp[n][n] 인 경우 연산 횟수 0
            return 0;
        if (e - s == 1)
            return (input[s].row * input[e].row * input[e].column);
        for (int j = s; j < e; j++) {
            //n >= 3인 경우, 앞 뒤 하나씩 구한 뒤 별도의 a 더하기
            int a = input[s].row * input[j + 1].row * input[e].column;
            min = Math.min(min, cntCal(s, j) + cntCal(j + 1, e) + a);

        }
        return dp[s][e] = min;
    }

    private static class Matrix {
        int row;
        int column;

        public Matrix(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
