package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1167_트리의지름 {
    static ArrayList<Edge>[] adjList;
    static boolean[] visited;
    static int[] distance;

    private static class Edge{
        int endPoint;
        int value;

        Edge(int e, int v){
            this.endPoint = e;
            this.value = v;
        }
    }

    public static void out() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        adjList = new ArrayList[N+1];
        visited = new boolean[N+1];
        distance = new int[N+1];

        for(int i = 1; i<adjList.length;i++){
            adjList[i] = new ArrayList<Edge>();
        }
        
        StringTokenizer st;
        for(int j = 1; j<=N; j++){
            st = new StringTokenizer(bf.readLine());
            int vertex = Integer.parseInt(st.nextToken());
            //-1 나올 때 까지 반복
            while(true){
                int end = Integer.parseInt(st.nextToken());
                if(end == -1) break;
                int value = Integer.parseInt(st.nextToken());
                adjList[vertex].add(new Edge(end, value));
            }
        }

        bfs(1);
        int maxNode = 1;
        for(int k = 2; k<=N;k++){
            if(distance[maxNode] < distance[k]){
                maxNode = k;
            }
        }
        //초기화 후 다시 bfs 실행
        visited = new boolean[N+1];
        distance = new int[N+1];
        bfs(maxNode);
        int result = distance[1];
        for(int k = 2; k<distance.length;k++){
            if(result < distance[k]){
                result = distance[k];
            }
        }
        System.out.println(result);

    }

    private static void bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = true;
        while(!queue.isEmpty()){
            int nowNode = queue.poll();
            for(Edge v : adjList[nowNode]){
                int e = v.endPoint;
                int dist = v.value;
                if(!visited[e]){
                    queue.add(e);
                    visited[e] = true;
                    distance[e] = distance[nowNode] + dist;
                }
            }
        }

    }
}
