package 트리_알아보기;

import java.util.ArrayList;
import java.util.Scanner;

public class P1068_트리 {
    static int n, leafCnt, rootNode, delete;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    //static boolean isLeaf;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        adjList = new ArrayList[n];
        visited = new boolean[n];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < adjList.length; i++) {
            int k = sc.nextInt();
            if (k == -1) {
                rootNode = i;
            } else {
                adjList[i].add(k);
                adjList[k].add(i);
            }
        }
        delete = sc.nextInt();

        leafCnt = 0;
        DFS(rootNode);

        System.out.println(leafCnt);
    }

    private static void DFS(int now) {
        visited[now] = true;
        boolean isLeaf = true;
        if(now == delete)
            return;
        for (int next : adjList[now]) {
            if (!visited[next] && next != delete) {
                DFS(next);
                isLeaf = false;
            }
        }
        if (isLeaf)
            leafCnt++;
    }

    //답안에서는 이 함수 + delete = 루트노드 인 경우 별도 출력 처리해줌
    private static void DFS2(int now) {
        visited[now] = true;
        int cNode = 0;
        for (int i : adjList[now]) {
            if (!visited[i] && i != delete) {
                cNode++;
                DFS2(now);
            }
        }
        if (cNode == 0) {
            leafCnt++;
        }
    }
}
