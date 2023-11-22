package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_19003 {
    static int T, N, M, cnt;
    static ArrayList<String> strings;
    static String tmp;
    static boolean sym;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            strings = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                strings.add(br.readLine());
            }
            sym = false;
            cnt = 0;
            for (int i = 0; i < strings.size(); i++) {
                tmp = strings.get(i);
                if (isSymmetric(tmp) && !sym) {
                    cnt += M;
                    sym = true;
                } else {
                    for (int j = i+1; j < strings.size(); j++) {
                        if (getSymmetric(tmp).equals(strings.get(j))) {
                            strings.remove(j);
                            cnt += M*2;
                        }
                    }
                }
            }
            System.out.printf("#%d %d\n", t, cnt);
        }
    }

    private static boolean isSymmetric(String tmp) {
        int f = 0; int e = M-1;
        while (f < e) {
            if(tmp.charAt(f) != tmp.charAt(e)) return false;
            f++; e--;
        }
        return true;
    }

    private static String getSymmetric(String s) {
        StringBuilder arr = new StringBuilder(s);
        int f = 0; int e = M-1;
        while (f < e) {
            char p = arr.charAt(f);
            arr.setCharAt(f, arr.charAt(e));
            arr.setCharAt(e, p);
            f++; e--;
        }
        return arr.toString();
    }

}
