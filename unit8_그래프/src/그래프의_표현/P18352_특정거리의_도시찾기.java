package 그래프의_표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P18352_특정거리의_도시찾기 {
    static int N, M, K, X;
    static int[] visited;
    static ArrayList<Integer>[] adjList;
    //bfs method에서도 참고 가능하게 static 으로 선언

    public static void out() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N+1];
        for(int i=1; i<adjList.length; i++){
            adjList[i] = new ArrayList<>();
        }
        visited = new int[N+1];

        for(int j=0; j<M; j++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
        }

        bfs(X);
        //탐색이 끝난 경우 K 찾기
        for(int i=1; i<visited.length; i++){
            if(visited[i] == K){
                sb.append(i+"\n");
            }
        }
        if(sb.length()==0) sb.append(-1+"\n");
        System.out.print(sb);
    }

    private static void bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = 0;
        while(!queue.isEmpty()){
            int pNode = queue.poll();
            for(int nextNode : adjList[pNode]){
                if((visited[nextNode] == 0) &&(nextNode!=X)){ 
                    //시작 노드 재방문 방지
                    visited[nextNode] = visited[pNode]+1;
                    queue.add(nextNode);
                }
            }
        }
    }
}