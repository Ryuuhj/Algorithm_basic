package 벨만_포드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11657_타임머신 {
    static final int INF = Integer.MAX_VALUE;
    static Edge[] edgeList;
    static long [] D;
    static int N, M;

    public static void out() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edgeList = new Edge[M];
        D = new long[N+1];
        Arrays.fill(D, INF);
        D[1] = 0L;
        
        for(int i=0; i<M; i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edgeList[i] = new Edge(a, b, c);
        }

        boolean cycle = false;
        for(int i=0; i<N; i++){
            for(Edge edge : edgeList){
                
                if((D[edge.start] != INF) && (D[edge.end] > D[edge.start] + edge.w)){
                    D[edge.end] = D[edge.start]+ edge.w;
                    if(i==N-1) cycle = true;
                }
        }
        }

        
        if(cycle){
            System.out.println(-1);
            return;
        }
        else{
            StringBuilder sb = new StringBuilder();
            for(int idx=2; idx<D.length; idx++){
                if(D[idx]==INF) sb.append("-1\n");
                else sb.append(D[idx]+"\n");
            }
            System.out.println(sb);
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
