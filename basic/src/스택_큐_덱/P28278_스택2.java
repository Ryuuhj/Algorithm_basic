package 스택_큐_덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P28278_스택2 {
    static String[] st;
    static Stack<String> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        stack = new Stack<>();
        String cmd;

        while (N-- > 0) {
            cmd = br.readLine();
            if (cmd.length() > 1) {
                st = cmd.split(" ");
                stack.push(st[1]);
            } else {
                sb.append(getStack(cmd)).append("\n");
            }
        }
        System.out.println(sb);

    }
    private static String getStack(String cmd){
        switch (cmd) {
            case "2":
                if(stack.empty())
                    return "-1";
                return stack.pop();
            case "3":
                return stack.size() + "";
            case "4":
                if(stack.empty())
                    return "1";
                return "0";
            case "5":
                if (stack.empty())
                    return "-1";
                return stack.peek();
        }
        return null;
    }
}
