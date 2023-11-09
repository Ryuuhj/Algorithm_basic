package D3;

import java.io.*;

public class Solution_17319 {
    static int N;
    static String S, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            S = br.readLine();
            if (N % 2 == 0 && S.substring(0, N / 2).equals(S.substring(N / 2, N)))
                ans = "Yes";
            else ans = "No";
            bw.write("#" + t + " " + ans + "\n");
        }
        bw.flush();
        bw.close();
    }
}
