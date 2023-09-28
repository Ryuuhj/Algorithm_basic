package 스택_큐_덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class P28279_덱2 {
    static StringBuilder sb = new StringBuilder();
    static Deque<Integer> dq = new ArrayDeque<>();
    static String[] cmd;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        while (N-- > 0) {
            cmd = bf.readLine().split(" ");
            if (cmd.length > 1) {
                if (cmd[0].equals("1"))
                    dq.offerFirst(Integer.parseInt(cmd[1]));
                else if (cmd[0].equals("2")) {
                    dq.offerLast(Integer.parseInt(cmd[1]));
                }
            } else {
                sb.append(printDeque(Integer.parseInt(cmd[0]))).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int printDeque(int cmd) {
        switch (cmd) {
            case 3:
                return dq.isEmpty() ? -1 : dq.removeFirst();
            case 4:
                return dq.isEmpty() ? -1 : dq.removeLast();
            case 5:
                return dq.size();
            case 6:
                return dq.isEmpty() ? 1 : 0;
            case 7:
                return dq.isEmpty() ? -1 : dq.getFirst();
            case 8:
                return dq.isEmpty() ? -1 : dq.getLast();
        }
        return 0;
    }
}
