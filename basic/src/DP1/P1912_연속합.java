package DP1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class P1912_연속합 {
    static long[] arr, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr =  Arrays.stream(br.readLine().split(" ")).mapToLong(Integer::parseInt).toArray();
        long[] dp = new long[n];
        
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            arr[i] = Math.max(arr[i], arr[i - 1] + arr[i]);
            dp[i] = Math.max(dp[i - 1], arr[i]);
        }
        System.out.println(dp[n - 1]);
    }
}
