package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P7193_승현이의_수학공부 {
    static int N, rest;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            rest = 0;
            char[] X = st.nextToken().toCharArray();
            for (char c : X) {
                rest += c - '0';
            }

            System.out.printf("#%d %d\n", t, rest % (N - 1));
        }
    }
}
