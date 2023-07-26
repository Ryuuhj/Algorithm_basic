package 최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1197_최소스패닝트리 {
    static int V, E;
    static PriorityQueue<Edge> eQueue;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        eQueue = new PriorityQueue<>();
        parent = new int[V + 1];
        Arrays.setAll(parent, e -> e);

        while (E-- > 0) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            eQueue.add(new Edge(a, b, c));
        }
        int answer = kruskal();

        System.out.println(answer);
    }

    private static int kruskal() {
        int accVal = 0, edgeCount = 0;
        while (edgeCount < V-1) {
            Edge edge = eQueue.poll();
             if (find(edge.s) != find(edge.e)) {
                 union(edge.s, edge.e);
                 accVal += edge.value;
                 edgeCount++;
             }


        }
        return accVal;
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }

    private static class Edge implements Comparable<Edge> {
        int s;
        int e;
        int value;

        public Edge(int s, int e, int value) {
            this.s = s;
            this.e = e;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return this.value > o.value ? 1 : -1;
        }
    }
}
