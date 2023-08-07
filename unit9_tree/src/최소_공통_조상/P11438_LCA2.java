package 최소_공통_조상;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P11438_LCA2 {
    static StringTokenizer st;
    static ArrayList<Integer>[] tree;
    static int[] depth;
    static boolean[] visited;
    static int kMax;
    static int[][] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        tree = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        depth = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        //최대 깊이 kMax 구하기
        int tmpN = 1;
        kMax = 0;
        while (tmpN <= N) {
            tmpN <<= 1; //비트열 왼쪽으로 1칸 이동 (2제곱 하기)
            kMax++;
        }
        parent = new int[kMax + 1][N + 1];
        //BFS 진행, depth 배열 및 parent[0] 채우기
        bfs(1);
        //점화식 이용해 parent 배열 채우기
        for (int k = 1; k <= kMax; k++) {
            for (int j = 1; j <= N; j++) {
                parent[k][j] = parent[k - 1][parent[k - 1][j]];
            }
        }
        //M 입력 받고 LCA
        int M = Integer.parseInt(bf.readLine());
        StringBuilder answer = new StringBuilder();
        while (M-- > 0) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int result = executeLCA(s, e);
            answer.append(result + "\n");
        }
        System.out.println(answer);
    }

    private static int executeLCA(int s, int e) {
        if (depth[s] > depth[e]) {
            int tmp = e;
            e = s;
            s = tmp;
        }
        //깊이가 다른 경우 처리
        for (int k = kMax; k >= 0; k--) {
            if (Math.pow(2, k) <= depth[e] - depth[s]) {
                if (depth[s] <= depth[parent[k][e]]) { //s보다 크거나 같아야 함
                    e = parent[k][e];
                }
            }
        }
        //깊이가 같아지면 공통 조상
        for (int k = kMax; k >= 0; k--) {
            if (parent[k][s] != parent[k][e]) { //달라지는 최초 노드
                s = parent[k][s];
                e = parent[k][e];

            }
        }
        int lca = s; //s==e인 경우 그냥 s 출력
        if(s != e){
            lca = parent[0][s];
        }
        return lca;
    }

    private static void bfs(int root) {
        Queue<Integer> queue = new LinkedList<Integer>();
        int level = 1, sibling = 1, nodeCnt = 0;
        queue.add(root);
        visited[root] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : tree[now]) {
                if(visited[next]) continue;
                visited[next] = true;
                parent[0][next] = now;
                depth[next] = level;
                queue.add(next);
            }
            nodeCnt++;
            if (nodeCnt == sibling) {
                nodeCnt = 0;
                sibling = queue.size();
                level++;
            }
        }
    }
}
