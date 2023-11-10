package hd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 징검다리 {
     static int N, max;
     static int[] A, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dp = new int[N];
        Arrays.fill(dp, 1);

        getMax();
        max = Arrays.stream(dp).max().getAsInt();
        System.out.println(max);
    }

    static void getMax() {
        int find = 0;
        for (int i = 1; i < N; i++) {
            find = dp[i];
            for (int j = 0; j < i; j++) {
                if(A[j] < A[i])
                    find = Math.max(find, dp[j]);
            }
            dp[i] += find;
        }
    }
}
