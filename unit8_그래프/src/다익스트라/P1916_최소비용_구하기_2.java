package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1916_최소비용_구하기_2 {
    static int N, M;
    static ArrayList<Node>[] adjLists;
    static int[] dist;
    static boolean[] visit;
    public static void out() throws IOException{
        final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());
        adjLists = new ArrayList[N+1];
        dist = new int[N+1];
        visit = new boolean[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i=0; i<=N; i++){
            adjLists[i] = new ArrayList<Node>();
        }

        for(int i=1; i<M; i++){
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adjLists[s].add(new Node(e, w));
        }
        st = new StringTokenizer(bf.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        sb.append(dijkstra(start, end));
        System.out.println(sb);

    }

    private static Object dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        while(!pq.isEmpty()){
            Node nowNode = pq.poll();
            int now = nowNode.targetNode;
            if(!visit[now]){// continue 대신 방문하지 않은 노드에 대해서만 처리
                visit[now] = true;
                for(Node n : adjLists[now]){
                    if(dist[n.targetNode] > dist[now] + n.value){
                        dist[n.targetNode] = dist[now] + n.value;
                        pq.add(new Node(n.targetNode, dist[n.targetNode]));
                    }
                }
            }
        }
        return dist[end];
    }
}
class Node implements Comparable<Node>{
    int targetNode;
    int value;
    Node(int targetNode, int value){
        this.targetNode = targetNode;
        this.value = value;
    }

    @Override
    public int compareTo(Node o){
        return value - o.value;
    }
}