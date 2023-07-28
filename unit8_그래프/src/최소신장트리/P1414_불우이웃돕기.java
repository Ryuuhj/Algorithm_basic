package 최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class P1414_불우이웃돕기 {
    static int n, total;
    static int[] parent;
    static PriorityQueue<Edge> eq;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        parent = new int[n + 1];
        Arrays.setAll(parent, e -> e);
        eq = new PriorityQueue<>();
        total = 0;

        for (int i = 1; i <= n; i++) {
            String input = bf.readLine();
            for (int j = 1; j <= n; j++) {
                char ch = input.charAt(j - 1);
                int value;
                if (ch == '0') continue;
                else if (Character.isUpperCase(ch))
                    value = ch - 'A' + 27;
                else
                    value = ch - 'a' + 1;

                if (i != j)
                    eq.add(new Edge(i, j, value));
                //System.out.println(value);
                total += value;
            }
        }
        //System.out.println(total);
        int min = kruskal();
        if (min == -1)
            System.out.println(min);
        else
            System.out.println(total - min);

    }

    private static int kruskal() {
        int edgeCount = 0, accValue = 0;
        while (!eq.isEmpty()) {
            Edge now = eq.poll();
            if (find(now.start) != find(now.end)) {
                //Arrays.stream(parent).forEach(e -> System.out.print(e+" "));
                union(now.start, now.end);
                edgeCount++;
                accValue += now.value;
            }
        }
        if (edgeCount != n - 1) {
            return -1;
        }else{
            return accValue;
        }
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
        if(rootA <= rootB)
            parent[rootB] = rootA;
        else
            parent[rootA] = rootB;
    }

    private static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int value;

        Edge(int s, int e, int value) {
            this.start = s;
            this.end = e;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return this.value - o.value;
        }
    }
}
