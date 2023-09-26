package 스택_큐_덱;

import java.io.*;
import java.util.Stack;

public class P4949_균형잡힌_세상 {
    static char[] line;
    static boolean flag;
    static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            flag = true;
            stack = new Stack<>();
            line = br.readLine().toCharArray();
            if (line[0] == '.')
                break;

            for (Character c : line) {
                if(c.equals('(') || c.equals('['))
                    stack.push(c);
                else if (c.equals(')')) {
                    if (stack.empty() || !stack.peek().equals('(')) {
                        flag = false;
                        break;
                    }
                    stack.pop();
                } else if (c.equals(']')) {
                    if (stack.empty() || !stack.peek().equals('[')) {
                        flag = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if(flag && stack.empty()) bw.write("yes\n");
            else bw.write("no\n");
        }
        bw.close();
    }
}
