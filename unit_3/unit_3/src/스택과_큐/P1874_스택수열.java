package 스택과_큐;

import java.util.Scanner;
import java.util.Stack;

public class P1874_스택수열 {
    
    public static void out(){
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();

        int N = sc.nextInt();
        int[] output = new int[N+1];
        Stack<Integer> stack =new Stack<>();

        for(int i=1; i<output.length;i++){
            output[i] = sc.nextInt();
        }

        int num = 1;
        boolean result = true;
        
        for(int i=1; i<output.length;i++){
            int compare = output[i];
            if(num <= compare){
                while(num <= compare){
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }
            else{
                int k = stack.pop();
                if(k != compare){
                    System.out.println("NO");
                    result = false;
                    break;
                }
                sb.append("-\n");
            }
        }
        if (result) System.out.println(sb.toString());
    }
}
