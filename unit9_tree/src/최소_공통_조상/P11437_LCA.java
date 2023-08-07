package 최소_공통_조상;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11437_LCA {
    static ArrayList<Integer>[] tree;
    static int[] parent, depth;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(bf.readLine());
        tree = new ArrayList[n + 1];
        for (int i = 1; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }
        parent = new int[n + 1];
        depth = new int[n + 1];
        visited = new boolean[n + 1];
        while (n-- > 1) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        //dfs 진행하며 부모노드, 깊이 저장
        int height = 0;
        dfs(1, height);
        //질의 m번 실행
        int m = Integer.parseInt(bf.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(bf.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            executeLCA(n1, n2);
        }

    }

    private static void executeLCA(int n1, int n2) {
        //깊이 다르면 먼저 맞춰줌
        while (depth[n1] != depth[n2]) {
            if (depth[n1] > depth[n2]) {
                n1 = parent[n1];
            } else {
                n2 = parent[n2];
            }
        }
        //깊이 같아지고 두 노드 다른 경우 -> 동시에 부모 노드로 이동
        while (n1 != n2) {
            n1 = parent[n1];
            n2 = parent[n2];
        }
        System.out.println(n1);
    }

    private static void dfs(int now, int height) {
        if(visited[now]) return;
        visited[now] = true;
        depth[now] = height;
        height++;
        for (int next : tree[now]) {
            if(visited[next]) continue;
            parent[next] = now;
            dfs(next, height);
        }
    }


}
