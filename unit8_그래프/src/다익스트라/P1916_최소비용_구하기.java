package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1916_최소비용_구하기 {
    final static int INF = 100000*999+1;
    static ArrayList<Edge>[] adjList;
    static int[] distance;
    static boolean[] visitied;

    public static void out() throws IOException{
        final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(bf.readLine()); 
        int M = Integer.parseInt(bf.readLine()); 
        //배열 초기화
        adjList = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            adjList[i] = new ArrayList<>();
        }
        distance = new int[N+1];
        Arrays.fill(distance, INF);
        visitied = new boolean[N+1];
        //인접리스트 채우기
        for(int i=0; i<M; i++){
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjList[s].add(new Edge(e, v));
        }
        //시작 노드, 도착 노드
        st = new StringTokenizer(bf.readLine());
        int S = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());

        //다익스트라 알고리즘 실행
        dijkstra(S);
        
        System.out.println(distance[A]);

    }


    private static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        distance[start] = 0;
        pq.add(new Edge(start, 0));
        while(!pq.isEmpty()){
            Edge nowEdge = pq.poll();
            int nowV = nowEdge.vertex;
            if(visitied[nowV]) continue; //방문한 노드면 스킵
            visitied[nowV] = true;

            for(Edge nextEdge : adjList[nowV]){
                int nextV = nextEdge.vertex;
                int value = nextEdge.value;
                if(distance[nowV]+value < distance[nextV]){
                    distance[nextV] = distance[nowV]+value;
                    //갱신된 값으로 등록
                    pq.add(new Edge(nextV, distance[nextV]));
                }
            }
        }
    }


    private static class Edge implements Comparable<Edge>{
        int vertex;
        int value;

        public int getVertex() {
            return vertex;
        }

        public int getValue() {
            return value;
        }

        public Edge(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }

        @Override
        public int compareTo(Edge edge){
            if(this.value > edge.getValue())
                return 1;
            else
                return -1;
        }
    }

}
