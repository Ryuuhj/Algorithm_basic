package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1244 {
    static int T, swapCnt, max;
    static StringBuilder nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            nums = new StringBuilder(st.nextToken());
            swapCnt = Integer.parseInt(st.nextToken());
            max = Integer.MIN_VALUE;
            if(nums.length() < swapCnt)
                swapCnt = nums.length();
            getMax(0, swapCnt);
            System.out.printf("#%d %d\n", t, max);
        }
    }

    private static void swap(int i, int j) {
        char tmp = nums.charAt(i);
        nums.setCharAt(i, nums.charAt(j));
        nums.setCharAt(j, tmp);
    }

    private static void getMax(int start, int swapCnt) {
        if (swapCnt == 0) {
            max = Math.max(Integer.parseInt(nums.toString()), max);
            return;
        }
        for (int i = start; i < nums.length(); i++) {
            for (int j = 0; j < nums.length(); j++) {
                if(i == j) continue;
                swap(i, j);
                getMax(i, swapCnt - 1);
                swap(i, j);
            }
        }
    }
}
