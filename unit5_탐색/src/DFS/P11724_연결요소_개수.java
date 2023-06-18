package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11724_연결요소_개수 {
    static int n, m;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;

    public static void out() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int connectCnt = 0; //연결 요소 개수
        //노드, 간선 개수 확보
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //1 ~ n+1 까지 노드 존재
        adjList = new ArrayList[n+1];
        visited = new boolean[n+1];

        //인접 리스트 초기화
        for(int i=1;i<adjList.length;i++){
            adjList[i] = new ArrayList<>(); //노드마다 인접 노드 담을 배열 달아주기
        }

        for(int i=1;i<=m;i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            
            adjList[n1].add(n2);
            adjList[n2].add(n1);
        }
        //DFS 수행
        for(int i=1; i<n+1;i++){
            if(!visited[i]){
                dfs(i, adjList, visited);
                //순환 끝나고 dfs 하나 끝났을 때
                connectCnt++;
            }
        }
        System.out.println(connectCnt);

    }

    private static void dfs(int v, ArrayList<Integer>[] adjList, boolean[] visited) {
        if(visited[v]) return;
        visited[v] = true;
        //v와 인접 노드에 대해 모두 방문 검사 -> 방문 하지 않은 노드에 대해 dfs 진행
        for(int n : adjList[v]){
            if(!visited[n]){
                dfs(n, adjList, visited);
            }
        }
    }
}
