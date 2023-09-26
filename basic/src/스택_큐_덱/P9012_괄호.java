package 스택_큐_덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P9012_괄호 {
    static String[] ps;
    static Stack<String> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            ps = br.readLine().split("");
            sb.append(isVPS(ps)).append("\n");
        }
        System.out.println(sb);
    }

    private static String isVPS(String[] ps) {
        stack = new Stack<>();

        for (String token : ps) {
            if (token.equals("(")) {
                stack.push(token);
            } else {
                if(stack.empty()||stack.peek().equals(")")) //순서 주의
                    return "NO";

                else if (stack.peek().equals("(")) {
                    stack.pop();
                }
            }
        }
        if(!stack.empty())
            return "NO";

        return "YES";
    }
}
