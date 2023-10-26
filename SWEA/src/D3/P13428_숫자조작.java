package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P13428_숫자조작 {
    static StringBuilder n;
    static int len, max, min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            n = new StringBuilder(br.readLine());
            len = n.length();
            max = Integer.parseInt(n.toString());
            min = Integer.parseInt(n.toString());

            for (int i = 0; i < len - 1; i++) {
                changeS(i, i == 0);

            }
            sb.append("#").append(t + 1).append(" ").append(min).append(" ").append(max + "\n");
        }
        System.out.println(sb);
    }

    private static void changeS(int l, boolean isFirst) {
        int num = 0;
        for (int i = l + 1; i < len; i++) {
            if (!(isFirst && n.charAt(i) == '0')) {
                changeC(l, i);
                num = Integer.parseInt(n.toString());
                max = Math.max(max, num);
                min = Math.min(min, num);
                changeC(l, i);
            }
        }
    }

    private static void changeC (int left, int right) {
        char tmp = n.charAt(left);
        n.setCharAt(left, n.charAt(right));
        n.setCharAt(right, tmp);
    }
}
