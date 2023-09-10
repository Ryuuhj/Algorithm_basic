package 이차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2738_행렬덧셈 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] A = new int[N][M];
        int[][] B = new int[N][M];

        for (int i = 0; i < N; i++) {
            A[i] = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for (int i = 0; i < N; i++) {
            B[i] = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] answer = getSum(A, B, N, M);

        printMatrix(answer);

    }

    private static int[][] getSum(int[][] a, int[][] b, int row, int column) {
        int[][] tmp = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                tmp[i][j] = (a[i][j] + b[i][j]);
            }
        }
        return tmp;
    }
    private static void printMatrix(int[][] x) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : x) {
            for (int e : row) {
                sb.append(e + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
