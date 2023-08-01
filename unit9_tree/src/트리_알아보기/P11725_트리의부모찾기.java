package 트리_알아보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11725_트리의부모찾기 {
    static ArrayList<Integer>[] adjList;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        int[] parentNode = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        adjList = new ArrayList[n + 1];

        //초기화
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        while (n-- > 1) {
            st = new StringTokenizer(bf.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            adjList[n1].add(n2);
            adjList[n2].add(n1);
        }

        dfs(1, visited, parentNode);

        StringBuilder ans = new StringBuilder();
        for (int i = 2; i < parentNode.length; i++) {
            ans.append(parentNode[i]+"\n");
        }
        System.out.println(ans);

    }

    private static void dfs(int nowNode, boolean[] visited, int[] parentNode) {
        visited[nowNode] = true;
        for (int nextNode : adjList[nowNode]) {
            if (!visited[nextNode]) {
                parentNode[nextNode] = nowNode;
                dfs(nextNode, visited, parentNode);
            }
        }
    }
}