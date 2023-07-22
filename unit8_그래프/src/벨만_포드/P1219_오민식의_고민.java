package 벨만_포드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1219_오민식의_고민 {
    static int n, m, a, b;
    final static long MAX = Long.MAX_VALUE;
    final static long MIN = Long.MIN_VALUE;
    static long[] dist;
    static int[] cityValue;
    static Edge[] edgeList;

    public static void out() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        edgeList = new Edge[m];
        dist = new long[n];
        cityValue = new int[n];
        Arrays.fill(dist, MIN);
        
        for(int i=0; i<m; i++){
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edgeList[i] = new Edge(s, e, c);
        }
        
        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<n; i++){
            cityValue[i] = Integer.parseInt(st.nextToken());
        }

        dist[a] = cityValue[a];
        //벨만 포드 실행
        for(int i=0; i<(n+100); i++){
            for(Edge edge : edgeList){
                if(dist[edge.s] == MIN)
                    continue;
                else if (dist[edge.s] == MAX) 
                    dist[edge.e] = MAX;
                else if (dist[edge.s] != MIN && (dist[edge.e] < dist[edge.s] - edge.c + cityValue[edge.e])) {
                    if(i > n-1)
                        dist[edge.e] = MAX;
                    else
                        dist[edge.e] = dist[edge.s] - edge.c + cityValue[edge.e]; 
                }
            }
        }
        //결과에 따라 나눠 출력
        if (dist[b]==MIN) {
            System.out.println("gg");
        } 
        else if(dist[b]==MAX){
            System.out.println("Gee");
        }else{
            System.out.println(dist[b]);
        }
        
    }

    private static class Edge{
        int s;
        int e;
        int c;

        Edge(int s, int e, int c) {
            this.s = s;
            this.e = e;
            this.c = c;
        }
        
    }

}
