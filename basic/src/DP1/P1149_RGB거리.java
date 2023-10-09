package DP1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1149_RGB거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        long[] cost = new long[3];
        long[] tmp;


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            if (i == 0) {
                cost[0] = Integer.parseInt(st.nextToken());
                cost[1] = Integer.parseInt(st.nextToken());
                cost[2] = Integer.parseInt(st.nextToken());
            } else {
                tmp = new long[]{ Math.min(cost[1], cost[2]), Math.min(cost[0], cost[2]), Math.min(cost[0], cost[1])};
                cost[0] = Integer.parseInt(st.nextToken()) + tmp[0];
                cost[1] = Integer.parseInt(st.nextToken()) + tmp[1];
                cost[2] = Integer.parseInt(st.nextToken()) + tmp[2];
            }
        }

        System.out.println(Arrays.stream(cost).min().getAsLong());

    }


}
