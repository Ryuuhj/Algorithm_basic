package D3;

import java.io.*;
import java.util.Stack;

public class P1220_Magnetic {
    static Stack<Integer>[] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int t = 1; t <= 10; t++) {
            board = new Stack[Integer.parseInt(br.readLine())];
            int cnt = 0;
            for (int i = 0; i < 100; i++) {
                board[i] = new Stack<>();
            }
            for (int i = 0; i < 100; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < 100; j++) {
                    if (!line[j].equals("0")) {
                        board[j].push(Integer.parseInt(line[j]));
                    }
                }
            }
            for (int i = 0; i < 100; i++) {
                cnt += getCount(i);
            }
            bw.write("#" + t + " " + cnt + "\n");
        }
        bw.close();
    }

    private static int getCount(int idx) {
        Stack<Integer> stack = board[idx];
        int cnt = 0;
        int m1 = 0,m2 = 0;
        if (stack.size() == 1) {
            return cnt;
        }
        while (!stack.empty()) {
            m1 = stack.pop();
            if(m1 == 2){
                while (!stack.empty()) {
                    m2 = stack.pop();
                    if (m2 == 1) {
                        cnt++;
                        break;
                    }
                }
            }
        }
        return cnt;
    }
}
