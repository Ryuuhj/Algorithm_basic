package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution_1225 {
    static int T, n;
    static Deque<Integer> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {
            br.readLine();
            deque = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 8; i++) {
                deque.addLast(Integer.parseInt(st.nextToken()));
            }
            loop1:
            while (true) {
                for (int i = 1; i <= 5; i++) {
                    n = deque.pollFirst();
                    deque.add(Math.max(n - i, 0));
                    if (n - i <= 0) break loop1;
                }
            }
            sb.append("#").append(tc).append(" ");
            while (!deque.isEmpty()) {
                sb.append(deque.pollFirst()).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
