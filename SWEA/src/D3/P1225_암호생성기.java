package D3;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P1225_암호생성기 {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = 10;
        while (T-- > 0) {
            int t = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 8; i++) {
                deque.addLast(Integer.parseInt(st.nextToken()));
            }
            bw.write("#" + t + " " + cycle(deque) + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static String cycle(Deque<Integer> deque) {
        int tmp = 0;
        loop:
        while(true) {
            for (int i = 1; i <= 5; i++) {
                tmp = deque.removeFirst() - i;
                if (tmp <= 0) {
                    deque.addLast(0);
                    break loop;
                }
                deque.addLast(tmp);
            }
        }
        return printPW(deque);
    }

    private static String printPW(Deque<Integer> deque) {
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.removeFirst()).append(" ");
        }
        return sb.toString();
    }
}
