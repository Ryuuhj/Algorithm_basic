package 백트레킹;

import java.util.Scanner;

public class P15649_N과M_1 {
    static boolean[] visited;
    static int[] nums;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();

        visited = new boolean[N + 1];
        nums = new int[M];
        dfs(N, M, 0);
        System.out.println(sb);
    }
    private static void dfs(int N, int M, int depth) {
        if (depth == M) {
            for (int n : nums) {
                sb.append(n + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                nums[depth] = i;
                dfs(N, M, depth + 1);
                //dfs 끝나면
                visited[i] = false;
            }
        }
    }
}
