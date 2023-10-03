package 백트레킹;

import java.util.Scanner;

public class P15652_N과M_4 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] ans;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
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
            ans[depth] = i;
            dfs(depth + 1);
        }

    }

}
