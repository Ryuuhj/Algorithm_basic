package 유클리드_호제법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1934_최소공배수 {
    static int T, A, B;
    public static void out() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder stringBuilder = new StringBuilder();

        T = Integer.parseInt(bf.readLine());
        for(int i=0; i<T; i++){
            st = new StringTokenizer(bf.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            int gcd = gcd(A, B);
            stringBuilder.append((A*B)/gcd+"\n");

        }
        System.out.print(stringBuilder);
    }
    private static int gcd(int a, int b) {
        if(b == 0) return a;

        return gcd(b, a % b);
    }
}
