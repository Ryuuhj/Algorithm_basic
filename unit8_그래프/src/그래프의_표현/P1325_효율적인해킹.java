package 그래프의_표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1325_효율적인해킹 {
    static int N, M;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static int[] reliability;
    public static void out() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[N+1];
        visited = new boolean[N+1];
        reliability = new int[N+1];

        for(int i=1; i<adjList.length; i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int k=0; k<M; k++){
            st= new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
        }
        //인접리스트 완료
        for(int i=1; i<adjList.length; i++){
            visited = new boolean[N+1];
            bfs(i);
        }
        //max 값 찾기
        int max = Arrays.stream(reliability).max().getAsInt();

        //max와 동일한 인덱스 찾아 저장
        for(int i=1; i<reliability.length; i++){
            if(reliability[i] == max)
                stringBuilder.append(i+" ");
        }
        System.out.print(stringBuilder);

    }
    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int pNode = queue.poll();
            for(int next : adjList[pNode]){
                if(!visited[next]){
                    visited[next] = true;
                    reliability[next]++;
                    queue.add(next);
                }
            }
        }

    }
}
