package 그래프의_표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1707_이분그래프 {
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static boolean[] binSet;
    static boolean flag;

    public static void out() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(bf.readLine()); //테스트 케이스
        StringBuilder answer = new StringBuilder();

        for(int i=0; i<K; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            //flag, adjList 초기화
            flag = true;
            adjList = new ArrayList[V+1];
            visited = new boolean[V+1];
            binSet = new boolean[V+1];

            for(int j=1; j<adjList.length; j++){
                adjList[j] = new ArrayList<Integer>();
            }
            //u, v -> 인접리스트 채우기
            for(int j=1; j<=E; j++){
                st = new StringTokenizer(bf.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                adjList[u].add(v);
                adjList[v].add(u);
            }
            //모든 노드에 대해 dfs 진행(그래프 일부만 연결될 경우)
            
            for(int n=1; n<adjList.length;n++){
                if(flag){
                    DFS(n);
                }
                else{ //중간에 false로 바뀌면 NO 출력 후 탐색 중지
                    answer.append("NO\n");
                    break;
                }
            }
            if(flag)
                answer.append("YES\n"); //모든 노드에 대해 true 유지하면 YES
        }
        System.out.print(answer);
    
    }

    private static void DFS(int n) {
        //n은 방문 처리 먼저
        visited[n] = true;
        //인접 노드 처리
        for(int next : adjList[n]){
            //인접 노드가 이미 방문된 상태의 경우(=속한 집합이 있는 경우)
            if(visited[next]){
                if(binSet[n] == binSet[next]){
                    flag = false;
                    break; //하나라도 겹치면 for문 탈출, dfs 끝
                }
            }else{ //방문하지 않은 노드
                binSet[next] = !binSet[n]; //현재 노드와 반대 집합에 할당
                DFS(next);
            }
        }
    }
}
