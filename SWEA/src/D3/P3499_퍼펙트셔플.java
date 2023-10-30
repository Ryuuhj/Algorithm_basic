package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P3499_퍼펙트셔플 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static String[] cards, shuffled;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            cards = br.readLine().split(" ");
            int l = 0, r = (int) Math.ceil((double) N / 2);
            shuffled = new String[N];
            int idx = 0;
            while (idx < N) {
                shuffled[idx++] = cards[l++];
                if (idx == N) break;
                shuffled[idx++] = cards[r++];
            }
            sb.append("#" + t + " ");
            for (String s : shuffled) {
                sb.append(s + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
