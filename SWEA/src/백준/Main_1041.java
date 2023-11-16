package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1041 {
    static int N;
    static long[] minCnt;
    static int[][] opposite;
    static int[] dice;
    static long min, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        minCnt = new long[]{((long)(N - 2) * (N - 2) * 5 + 4L * (N - 2)), 8L * (N - 2) + 4, 4};
        ans = 0;
        dice = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        if (N == 1) {
            Arrays.sort(dice);
            ans = Arrays.stream(dice).sum() - dice[5];
        } else {
            //1. 1면
            ans = Arrays.stream(dice).min().getAsInt() * minCnt[0];
            //2.면 2개
            min = Integer.MAX_VALUE;
            for (int i = 0; i < 5; i++) {
                for (int j = i + 1; j < 6; j++) {
                    if (i + j != 5)
                        min = Math.min(min, dice[i] + dice[j]);
                }
            }
            ans += min * minCnt[1];
            //3. 면 3개
            min = 0;
            for (int i = 0; i < 3; i++) { //제일 작은 수
                min += Math.min(dice[i], dice[5 - i]);
            }
            ans += min * minCnt[2];
        }
        System.out.println(ans);
    }
}