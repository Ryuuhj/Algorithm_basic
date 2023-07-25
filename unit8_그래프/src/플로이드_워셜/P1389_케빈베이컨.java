package 플로이드_워셜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1389_케빈베이컨 {
    static int n, m;
    static int[][] distance;
    static int[] kbNums;
    final static int INF = 1000001;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        distance = new int[n + 1][n + 1];
        kbNums = new int[n + 1];
        for (int i=1; i<distance.length; i++) {
            for (int j = 1; j < distance[i].length; j++) {
                if (i == j)
                    continue;
                distance[i][j] = INF;
            }
        }
        Arrays.fill(kbNums, INF);

        while (m-- > 0) {
            st = new StringTokenizer(bf.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            distance[i][j] = 1;
            distance[j][i] = 1;
        }
        floyd(n, distance);
        //System.out.println(Arrays.deepToString(distance));

        for (int i = 1; i <= n; i++) {
            kbNums[i] = Arrays.stream(distance[i]).sum();
            System.out.println(kbNums[i]);
        }
        int min = Arrays.stream(kbNums).min().getAsInt();

        for (int i=1; i< kbNums.length; i++) {
            if (kbNums[i] == min) {
                System.out.println(i);
                return;
            }
        }

    }
    private static void floyd(int n, int[][] distance){
        for (int k = 1; k <= n; k++) {
            for (int s = 1; s <= n; s++) {
                for (int e = 1; e <= n; e++) {
                    if (distance[s][e] > distance[s][k]+distance[k][e])
                        distance[s][e] = distance[s][k] + distance[k][e];
                }
            }
        }
    }
}
