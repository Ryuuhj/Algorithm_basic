package D3;

import java.io.*;
import java.util.StringTokenizer;

public class P1217_거듭제곱 {
    static int k, tmp;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int t = 1; t <= 10; t++) {
            k = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            tmp = 1;
            bw.write("#" + k + " " + getPow(N, M) + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static int getPow(int n, int m) {
        if (m == 0)
            return tmp;
        tmp *= n;
        return getPow(n, m - 1);
    }
}
