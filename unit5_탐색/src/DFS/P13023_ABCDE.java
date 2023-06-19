package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P13023_ABCDE {
    static int N, M;
    static boolean result;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;

    public static void out() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = false;

        adjList = new ArrayList[N];
        //visited = new boolean[N];
        //인접리스트 초기화 꼭!!
        for(int i = 0;i<adjList.length;i++){
            adjList[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }
        //dfs 수행
        for(int i=0;i<N;i++){
            visited = new boolean[N];
            dfs(i,1);
            if(result)
                break;
        }
        if(result) System.out.println(1);
        else System.out.println(0);
    }

    private static void dfs(int v, int depth) {
        if(visited[v]) return;
        if(depth == 5 || result){
            result = true;
            return;
        }
        visited[v] = true;
        for(int n : adjList[v]){
            if(!visited[n]){
                dfs(n, depth+1);
            }
        }
        visited[v]=false;
    }
}
