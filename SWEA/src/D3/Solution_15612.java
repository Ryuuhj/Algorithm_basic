package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution_15612 {
    static int T;
    static boolean flag;
    static String[] input;
    static Set<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            set = new HashSet<>();
            input = new String[8];
            for (int i = 0; i < 8; i++) {
                input[i] = br.readLine();
            }
            loop1:
            for (int i = 0; i < 8; i++) {
                flag = false;
                for (int j = 0; j < 8; j++) {
                    if (input[i].charAt(j) == 'O') {
                        if(set.contains(j) || flag) break loop1;
                        set.add(j);
                        flag = true;
                    }
                }
            }
            if (set.size() == 8) {
                System.out.printf("#%d yes\n", t);
            }else
                System.out.printf("#%d no\n", t);
        }
    }
}
