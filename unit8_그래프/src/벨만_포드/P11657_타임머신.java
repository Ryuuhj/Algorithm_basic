package 벨만_포드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11657_타임머신 {
    static final int INF = 6000*499 +1;
    static Edge[] edgeList;
    static int[] D;
    static int N, M;

    public static void out() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edgeList = new Edge[M];
        D = new int[N+1];
        Arrays.fill(D, INF);
        D[1] = 0;
        
        for(int i=0; i<M; i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edgeList[i] = new Edge(a, b, c);
        }

        for(int i=0; i<N-1; i++){
            bf();
        }
        if(isCycle()){
            System.out.println(-1);
            return;
        }
        
    }

    
    private static boolean isCycle() {
        return false;
    }


    private static void bf() {
        for(int i=0; i<M; i++){
            Edge edge = edgeList[i];
            if((edge.start!=INF) && (D[edge.end] > D[edge.start] + edge.w)){
                D[edge.end] = D[edge.start]+ edge.w;
            }
        }
    }


    static class Edge{
        int start;
        int end;
        int w;

        Edge(int start, int end, int w) {
            this.start = start;
            this.end = end;
            this.w = w;
        }
                
    }
}
