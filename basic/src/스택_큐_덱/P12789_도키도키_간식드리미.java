package 스택_큐_덱;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class P12789_도키도키_간식드리미 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int now = 1;
        boolean flag = true;
        Stack<Integer> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = 0;
        while (N-- > 0) {
            k = Integer.parseInt(st.nextToken());
            //stack안 숫자들 고려
            while (!stack.empty() && stack.peek() == now) {
                stack.pop();
                now++;
            }
            if (k == now) {
                now++;
            } else {
                if(stack.empty() ||(stack.peek() > k)){
                    stack.push(k);
                } else if (stack.peek() <= k) {
                    flag = false;
                    break;
                }
            }
        }
        if (flag) bw.write("Nice");
        else bw.write("Sad");
        bw.close();
    }
}
