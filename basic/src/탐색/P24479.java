package 탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class P24479 {
    static int N, M, R, u, v, depth;
    static ArrayList<Integer>[] graph;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        visited = new int[N + 1];
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
        depth = 1;
        visited[R] = depth;
        dfs(R);
        for (int i = 1; i <= N; i++) {
            System.out.println(visited[i]);
        }
    }

    private static void dfs(int now) {
        for (int next : graph[now]) {
            if (visited[next] == 0) {
                visited[next] = ++depth;
                dfs(next);
            }
        }
    }
}
