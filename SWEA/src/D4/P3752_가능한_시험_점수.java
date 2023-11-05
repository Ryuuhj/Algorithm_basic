package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P3752_가능한_시험_점수 {
    static Set<Integer> set;
    static int N;
    static int[] points;
    static Set<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            points = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            getScore();
            sb.append("#").append(t).append(" ").append(tree[N-1].size()).append("\n");
        }
        System.out.println(sb);
    }

    private static void getScore() {
        tree = new Set[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new HashSet<>();
        }
        tree[0].add(0);
        tree[0].add(points[0]);
        for (int i = 1; i < N; i++) {
            for (int n : tree[i - 1]) {
                tree[i].add(n);
                tree[i].add(n + points[i]);
            }
        }
    }
}
