package 스택과_큐;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class P17298_오큰수 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;

    public static void out() throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        int[] sol = new int[N];

        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        for(int j=0;j<N;j++){

            while(!stack.isEmpty() && (A[stack.peek()] < A[j])){
                int idx = stack.pop();
                sol[idx] = A[j];
            }
            stack.push(j);
        }
        
        while(!stack.isEmpty()){
            int idx = stack.pop();
            sol[idx] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int ans : sol){ bw.write(ans+" "); }
        bw.write("\n");
        bw.flush();
    }

}
