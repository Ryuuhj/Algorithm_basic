package D3;

import java.util.Scanner;
import java.util.Stack;

public class Solution_8931 {
    static int TC, K, n;
    static long sum;
    static Stack<Integer> stack;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        TC = sc.nextInt();
        for (int t = 1; t <= TC; t++) {
            stack = new Stack<>();
            K = sc.nextInt();
            sum = 0;
            for (int i = 0; i < K; i++) {
                n = sc.nextInt();
                if(n != 0)
                    stack.push(n);
                else stack.pop();
            }
            while (!stack.empty()) {
                sum += stack.pop();
            }
            sb.append("#").append(t).append(" ").append(sum).append("\n");
        }
        System.out.print(sb);
    }
}
