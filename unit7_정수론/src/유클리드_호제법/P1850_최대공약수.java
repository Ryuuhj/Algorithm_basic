package 유클리드_호제법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1850_최대공약수 {
    static long A, B;
    public static void out() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        long cnt = gcd(A, B);

        String ans = "1".repeat((int)cnt);
        System.out.println(ans);

    }

    private static long gcd(long a, long b) {
        if(b==0) return a;
        return gcd(b, a % b);
    }
}
