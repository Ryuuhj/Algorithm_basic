package D3;

import java.util.Arrays;
import java.util.Scanner;

public class P3282_01Knapsack {
    static int N, K;
    static Stuff[] arr;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            ;
            N = sc.nextInt();
            K = sc.nextInt();
            arr = new Stuff[N+1];
            for (int i = 1; i <= N; i++) {
                arr[i] = new Stuff(sc.nextInt(), sc.nextInt());
            }
            dp = new int[N+1][K+1];
            for (int i = 1; i <= N; i++) {
                for (int j = 0; j <= K; j++) { //가방 무게 별 가능
                    if(arr[i].v > j)//가방 부피 한도보다 큰 경우
                        dp[i][j] = dp[i - 1][j]; //안 넣음
                    else // 부피 한도보다 작은 경우
                        dp[i][j] = Math.max(dp[i - 1][j - arr[i].v] + arr[i].c, dp[i - 1][j]);
                    // i번째 물건 넣는 경우/넣지 않는 경우 중 최대
                }
            }
            sb.append("#").append(t + 1).append(" ").append(dp[N][K]).append("\n");
        }
        System.out.println(sb);
    }


    static class Stuff{
        int v,c;

        Stuff(int v, int c) {
            super();
            this.v = v;
            this.c = c;
        }

    }
}
