package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class P1244_최대상금 {
    static ArrayList<Integer> order;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String[] line = br.readLine().split(" ");
            int cnt = Integer.parseInt(line[1]);

            int[] nums = Arrays.stream(line[0].split("")).mapToInt(Integer::parseInt).toArray();

            order = new ArrayList<>();
            Arrays.stream(nums).forEach(order::add);
            Collections.sort(order, Collections.reverseOrder());

            answer = Integer.MIN_VALUE;
            swapNumber(nums, cnt, 0);
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static void swapNumber(int[] nums, int cnt, int i) {
        if (cnt == 0) {
            answer = Math.max(answer, getValue(nums));
            return;
        }
        if (i == nums.length - 1) {
            if(cnt % 2 != 0)
                swap(nums, i - 1, i);
            answer = Math.max(answer, getValue(nums));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == order.get(i) && i < j) {
                swap(nums, i, j);
                swapNumber(nums, cnt-1, i+1);
                swap(nums, i, j);
            }
        }
        swapNumber(nums, cnt, i+1);
    }

    private static void swap(int[] nums, int i, int lastIdx) {
        int tmp = nums[i];
        nums[i] = nums[lastIdx];
        nums[lastIdx] = tmp;
    }
    private static int getValue(int[] nums) {
        int value = 0;
        for (int i = 0; i < nums.length; i++) {
            value += (nums[nums.length-(i+1)] * Math.pow(10, i));
        }
        return value;
    }

}
