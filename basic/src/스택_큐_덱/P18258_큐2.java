package 스택_큐_덱;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class P18258_큐2 {
    static Deque<Integer> dq;
    static String[] cmd;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        dq = new ArrayDeque<Integer>();

        while (N-- > 0) {
            cmd = br.readLine().split(" ");
            if (cmd[0].equals("push")) {
                dq.offer(Integer.parseInt(cmd[1]));
            } else {
                bw.write(printQueue(cmd[0]) + "\n");
            }
        }
        bw.close();
    }

    private static int printQueue(String cmd) {
        switch (cmd) {
            case "pop":
                return dq.isEmpty() ? -1 : dq.pollFirst();
            case "size":
                return dq.size();
            case "empty":
                return dq.isEmpty() ? 1 : 0;
            case "front":
                return dq.isEmpty() ? -1 : dq.peekFirst();
            case "back":
                return dq.isEmpty() ? -1 : dq.peekLast();
        }
        return 0;
    }
}
