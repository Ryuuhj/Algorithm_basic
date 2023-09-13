package 일반수학1;

import java.io.*;
import java.util.StringTokenizer;

public class P2869_달팽이_올라가기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        int tmp = (V - A) % (A - B);
        int days = 1;
        if (tmp != 0) {
            days += (V - A) / (A - B) + 1;
        }else {
            days += (V - A) / (A - B);
        }
        System.out.println(days);
    }
}
