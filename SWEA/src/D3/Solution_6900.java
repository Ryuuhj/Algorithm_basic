package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_6900 {
    static int T, N, M;
    static long total;
    static StringTokenizer st;
    static String tmp, w, m;
    static Lotto[] winning;
    static Set<String> mine;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            winning = new Lotto[N];
            mine = new HashSet<>();
            total = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                tmp = st.nextToken();
                int prize = Integer.parseInt(st.nextToken());
                int cnt = 0;
                for (char c : tmp.toCharArray()) {
                    if (c == '*') cnt++;
                }
                winning[i] = new Lotto(tmp, cnt, prize);
            }
            Arrays.sort(winning);
            for (int i = 0; i < M; i++) {
                tmp = br.readLine();
                mine.add(tmp);
            }
            for (int i = 0; i < N; i++) {
                w = winning[i].numbers;
                loop1:
                for (String m : mine) {
                    for (int j = 0; j < 8; j++) {
                        if (w.charAt(j) == m.charAt(j) || w.charAt(j) == '*') continue;
                        else continue loop1;
                    }
                    total += winning[i].prize;
                }
            }
            sb.append("#" + tc + " " + total + "\n");
        }
        System.out.println(sb);
    }



    private static class Lotto implements Comparable<Lotto>{
        String numbers;
        int cnt;
        int prize;

        Lotto(String n, int c, int p) {
            this.numbers = n;
            this.cnt = c;
            this.prize = p;
        }

        @Override
        public int compareTo(Lotto o) {
            if(this.cnt > o.cnt) return 1;
            else if (this.cnt < o.cnt) return -1;
            return 0;
        }
    }
}
