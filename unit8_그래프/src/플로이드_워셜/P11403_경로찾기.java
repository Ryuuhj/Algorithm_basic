package 플로이드_워셜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11403_경로찾기 {
    static int n;
    final static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(bf.readLine());
        int[][] distance = new int[n][n];
        for (int[] row : distance) {
            st = new StringTokenizer(bf.readLine());
            Arrays.setAll(row, e -> Integer.parseInt(st.nextToken()));

        }
        for (int k = 0; k < n; k++) {
            for (int s = 0; s < n; s++) {
                for (int e = 0; e < n; e++) {
                    if (distance[s][k]==1 && distance[k][e]==1) {
                        distance[s][e] = 1;
                    }
                }
            }
        }
        for (int[] row : distance) {
            for (int e : row) {
                sb.append(e + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
