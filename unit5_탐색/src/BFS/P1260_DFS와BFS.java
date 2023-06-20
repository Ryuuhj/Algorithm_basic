package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1260_DFS와BFS {
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    public static void out() throws IOException{
        int N, M, start;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i=1;i<N+1;i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int i=0;i<M;i++){
            st = new StringTokenizer(bf.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }
        //오름차순 정렬
        for(int j=1;j<adjList.length;j++){
            Collections.sort(adjList[j]);
        }
        dfs(start, stringBuilder);
        stringBuilder.append("\n");
        visited = new boolean[N+1];
        bfs(start, stringBuilder);
        
        System.out.println(stringBuilder);
    }
    
    private static void dfs(int v, StringBuilder stringBuilder) {
        if(visited[v]){
            return;
        }
        visited[v] = true;
        stringBuilder.append(v+" ");
        for(int n : adjList[v]){
            if(!visited[n]) dfs(n, stringBuilder);
        }
    }
    
    private static void bfs(int v, StringBuilder stringBuilder) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(v);
        visited[v] = true;
        while(!queue.isEmpty()){
            int node = queue.poll();
            stringBuilder.append(node+" ");
            for(int n : adjList[node]){
                if(!visited[n]){
                    queue.add(n);
                    visited[n] = true;
                }
            }
        }
    }
}
