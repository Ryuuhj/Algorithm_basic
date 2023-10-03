package 백트레킹;

import java.util.Scanner;

public class P15650_N과M_2 {
    static int N, M;
    static boolean[] used;
    static int[] ans;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        used = new boolean[N + 1];
        ans = new int[M];

        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if (depth == M) {
            for (int n : ans) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }
        int start = depth == 0 ? 1 : ans[depth - 1];
        for (int i = start; i <= N; i++) {
            if (!used[i]) {
                used[i] = true;
                ans[depth] = i;
                dfs(depth + 1);
                used[i] = false;
            }
        }
        return;
    }
}
