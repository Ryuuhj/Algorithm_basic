package 약수_배수_소수;

import java.io.*;
import java.util.StringTokenizer;

public class P5086_배수와약수 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        while (n1 != n2) {
            if (n1 % n2 == 0) {
                bw.write("multiple\n");
            } else if (n2 % n1 == 0) {
                bw.write("factor\n");
            } else {
                bw.write("neither\n");
            }
            st = new StringTokenizer(bf.readLine());
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());
        }
        bw.flush();
        bw.close();
    }
}
