package 탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2606 {
    static int V, E, n1, n2, cnt;
    static ArrayList<Integer>[] network;
    static int[] spreadOrder;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        network = new ArrayList[V + 1];
        spreadOrder = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            network[i] = new ArrayList<>();
        }
        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());
            network[n1].add(n2);
            network[n2].add(n1);
        }
        cnt = 0;
        bfs(1);
        System.out.println(cnt == 0 ? 0 : cnt-1); //컴퓨터가 1대인 경우, 연결된 컴 0
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : network[now]) {
                if (spreadOrder[next] == 0) {
                    spreadOrder[next] = ++cnt;
                    queue.add(next);
                }
            }
        }
    }
}
