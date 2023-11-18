package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1260 {
    static int N, M, V, u, v;
    static ArrayList<Integer>[] graph;
    static ArrayList<Integer> order;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }
        order = new ArrayList<>();
        visited = new boolean[N + 1];
        order.add(V);
        visited[V] = true;
        dfs(V, 1);
        for (int n : order) {
            sb.append(n + " ");
        }
        sb.append("\n");
        visited = new boolean[N + 1];
        bfs(V);
        System.out.println(sb);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[V] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now + " ");
            for (int next : graph[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        sb.append("\n");
    }

    private static void dfs(int pre, int depth) {
        if (depth == N) return;

        for (int next : graph[pre]) {
            if (!visited[next]) {
                visited[next] = true;
                order.add(next);
                dfs(next, depth + 1);
            }
        }
    }
}
