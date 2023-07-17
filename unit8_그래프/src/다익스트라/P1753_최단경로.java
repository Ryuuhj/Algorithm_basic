package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1753_최단경로 {
    static ArrayList<Node>[] adjList;
    final static int INF = 300000*19999+1;
    static int[] D;
    static boolean[] visitied;
    
    public static void out() throws IOException{
        final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        final int V = Integer.parseInt(st.nextToken());
        final int E = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(bf.readLine());

        adjList = new ArrayList[V+1];
        //adjList 초기화
        for(int i=1; i<=V; i++){
            adjList[i] = new ArrayList<>();
        }

        D = new int[V+1];
        Arrays.fill(D, INF);

        visitied = new boolean[V+1];

        for(int i=0; i<E; i++){
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adjList[u].add(new Node(v, w));
        }

        Dijkstra(K);

        for(int i=1; i<D.length; i++){
            if(D[i] == INF) sb.append("INF\n");
            else sb.append(D[i]+"\n");
        }

        System.out.println(sb);

    }

    static private void Dijkstra (int start){
        //다익스트라 초기 설정
        D[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node nowNode = pq.poll();
            int now = nowNode.number;
            if(visitied[now]) continue; //중복일 경우 스킵
            visitied[now] = true;

            for(int i=0; i<adjList[now].size(); i++){
                Node nextNode = adjList[now].get(i);
                int next = nextNode.number;

                if((D[now] + nextNode.value)  < D[next]){ //갱신 O
                    D[next] = D[now] + nextNode.value;
                    //갱신한 값으로 새로 노드 객체 생성해 삽입!
                    pq.add(new Node(next, D[next]));
                } 
            }
        }
    }

    static class Node implements Comparable<Node>{
        int number;
        int value;

        public int getNumber() {
            return number;
        }

        public int getValue() {
            return value;
        }

        public Node(int number, int value) {
            this.number = number;
            this.value = value;
        }
        
        @Override
        public int compareTo (Node node){
            if(this.value > node.getValue())
                return 1;
            else
                return -1;
        }
    }
}
