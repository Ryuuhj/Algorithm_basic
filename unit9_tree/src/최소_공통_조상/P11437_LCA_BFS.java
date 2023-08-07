package 최소_공통_조상;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P11437_LCA_BFS {
    static ArrayList<Integer>[] tree;
    static int[] depth;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < N - 1; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            tree[s].add(e);
            tree[e].add(s);
        }
        depth = new int[N + 1];
        parent = new int[N + 1];
        visited = new boolean[N + 1];
        //BFS로 부모노드, 깊이 갱신
        BFS(1);
        //질의 진행
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int LCA = executeLCA(a, b);
            System.out.println(LCA);
        }
    }

    private static int executeLCA(int a, int b) {
        //1번 노드의 깊이가 더 크도록 swap
        if (depth[a] < depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        //높이 다르면 맞춰주기
        while (depth[a] != depth[b]) {
            a = parent[a];
        }
        //높이 같으면 같은 조상 나올 때 까지 부모 노드로 한 칸씩
        while (a != b) {
            a = parent[a];
            b = parent[b];
        }
        return a;
    }

    private static void BFS(int n) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(n);
        visited[n] = true;
        int level = 1;
        int now_size = 1;
        int count = 0;
        while (!queue.isEmpty()) {
            int now_node = queue.poll();
            for (int next : tree[now_node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    parent[next] = now_node;
                    depth[next] = level;
                }
            }
            count++;
            if (count == now_size) { // 이번 높이에 해당하는 모든 노드 방문 시
                count = 0;
                now_size = queue.size(); //다음 높이에 해당하는 노드 개수 저장
                level++; //현재 배열의 depth 1 증가
            }
        }

    }

}
