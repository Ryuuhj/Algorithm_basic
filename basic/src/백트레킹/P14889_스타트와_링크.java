package 백트레킹;

import java.io.*;
import java.util.Arrays;

public class P14889_스타트와_링크 {
    static int N;
    static long min;
    static int[] AT;
    static int[][] stat;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        AT = new int[N];
        stat = new int[N][N];

        for (int i = 0; i < N; i++) {
            stat[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        min = Integer.MAX_VALUE;

        int startCnt = N / 2;
        int linkCnt = N / 2;

        startLink(startCnt, linkCnt, 0);


        System.out.println(min);

    }

    private static void startLink(long Scnt, long Lcnt, int idx) {
        if (idx == N) {
            calculate();
            return;
        }
        if (Scnt > 0) {
            AT[idx] = 1;
            startLink(Scnt-1, Lcnt, idx+1);
            AT[idx] = 0;
        }
        if (Lcnt > 0) {
            AT[idx] = 2;
            startLink(Scnt, Lcnt-1, idx + 1);
            AT[idx] = 0;
        }
    }

    private static void calculate() {
        long[] value = new long[3];
        for (int i = 0; i < N-1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (AT[j] == AT[i]) {
                    value[AT[j]] += (stat[i][j] + stat[j][i]);
                }
            }
        }
        min = Math.min(min, Math.abs(value[1] - value[2]));
        if (min == 0) {
            System.out.println(0);
            System.exit(0);
        }
    }
}
