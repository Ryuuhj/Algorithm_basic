package 스택_큐_덱;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P2346_풍선_터뜨리기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Ballon> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.offer(new Ballon(i, Integer.parseInt(st.nextToken())));
        }

        int cnt = 1;
        Ballon pop = null;
        while (!deque.isEmpty()) {
            if (cnt > 0) {
                cnt--;
                if (cnt == 0)
                    pop = deque.removeFirst();
                else
                    deque.offerLast(deque.removeFirst());

            } else if (cnt < 0) {
                cnt++;
                if (cnt == 0)
                    pop = deque.removeLast();
                else
                    deque.offerFirst(deque.removeLast());
            }
            if (cnt == 0) {
                bw.write(pop.order + " ");
                cnt = pop.step;
            }
        }
        bw.close();
    }

    private static class Ballon {
        int order;
        int step;

        public Ballon(int order, int step) {
            this.order = order;
            this.step = step;
        }
    }
}
