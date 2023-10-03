package 백트레킹;

import java.util.Scanner;

public class P15651_N과M_3 {
    static StringBuilder sb = new StringBuilder();
    static int[] ans;
    static int N, M;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();

        ans = new int[M];
        dfs(0);
        System.out.println(sb);

    }

    private static void dfs(int depth) {
        if(depth == M){
            for (int n : ans) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            ans[depth] = i;
            dfs(depth + 1);
        }
    }
}
