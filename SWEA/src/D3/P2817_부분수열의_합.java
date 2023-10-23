package D3;

import java.util.Scanner;

public class P2817_부분수열의_합 {
    static int N, K;
    static int[] arr;
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            K = sc.nextInt();
            arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            cnt = 0;
            dfs(0, 0);
            System.out.printf("#%d %d\n", t, cnt);
        }
    }

    private static void dfs(int idx, int sum) {
        if (idx == N || sum > K) {
            if(sum == K)
                cnt++;
            return;
        }
        dfs(idx + 1, sum + arr[idx]);
        dfs(idx + 1, sum);
    }
}
