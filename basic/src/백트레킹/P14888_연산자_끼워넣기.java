package 백트레킹;

import java.io.*;
import java.util.Arrays;

public class P14888_연산자_끼워넣기 {
    static int[] arr, operator;
    static int N ,max, min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        operator = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        getMaxMin(arr[0], 1);

        bw.write(max + "\n");
        bw.write(min + "\n");
        bw.close();
    }

    private static void getMaxMin(int now, int nextIdx) {
        if (nextIdx == N) {
            max = Math.max(max, now);
            min = Math.min(min, now);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                getMaxMin(calculate(now, nextIdx, i), nextIdx + 1);
                operator[i]++;
            }
        }
    }

    private static int calculate(int now, int nextIdx, int idx) {
        switch (idx) {
            case 0:
                return now + arr[nextIdx];
            case 1:
                return now - arr[nextIdx];
            case 2:
                return now * arr[nextIdx];
            case 3:
                if (arr[nextIdx] < 0) {
                    return -(now / (-arr[nextIdx]));
                }
                return now / arr[nextIdx];
        }
        return -1;
    }
}
