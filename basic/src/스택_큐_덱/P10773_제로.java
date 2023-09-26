package 스택_큐_덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P10773_제로 {
    static int K, n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        while (K-- > 0) {
            n = Integer.parseInt(br.readLine());
            if (n == 0 && !stack.empty()) {
                stack.pop();
            } else {
                stack.push(n);
            }
        }
        sb.append(getStackSum(stack));
        System.out.println(sb);

    }

    private static int getStackSum(Stack<Integer> stack) {
        int sum = 0;
        while (!stack.empty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
