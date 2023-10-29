package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P9229_한빈이와_SpotMart {
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> snacks;
    static int N, M, max, a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            snacks = new ArrayList<Integer>();
            st = new StringTokenizer(br.readLine());
            while (N-- > 0) {
                a = Integer.parseInt(st.nextToken());
                if(a < M)
                    snacks.add(a);
            }
            Collections.sort(snacks, Collections.reverseOrder());
            max = -1;
            for (int i = 0; i < snacks.size() - 1; i++) {
                max = Math.max(max, getMax(i, snacks.get(i)));
            }
            sb.append("#" + t + " " + max + "\n");
        }
        System.out.println(sb);
    }

    private static int getMax(int s, int w1) {
        int total = 0;
        for (int i = s + 1; i < snacks.size(); i++) {
            total = w1 + snacks.get(i);
            if(total <= M)
                return total;
        }
        return -1;
    }
}
