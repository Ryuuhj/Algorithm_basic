package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_13432 {
    static int T, n, s, t;
    static boolean[] visited;
    static int minEdge;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int k = 1; k <= T; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            visited = new boolean[n + 1];

            minEdge = -1;
            if(s == t) minEdge = 0;
            else if (t != 1 || s != 1) {
                bfs(s);
            }
            System.out.printf("#%d %d\n", k, minEdge);
        }
    }

    private static int gcd(int i, int j) {
        if(j == 0) return i;
        return gcd(j, i % j);
    }

    private static void bfs(int start) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0));
        visited[start] = true;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 2; i <= n; i++) {
                if (!visited[i] && gcd(now.num, i) != 1) {
                    if (i == t) {
                        minEdge = now.cnt+1;
                        return;
                    }
                    visited[i] = true;
                    queue.add(new Node(i, now.cnt+1));
                    visited[i] = false;
                }
            }
        }
    }
    private static class Node{
        int num; int cnt;

        Node(int n, int c) {
            this.num = n;
            this.cnt = c;
        }
    }
}
