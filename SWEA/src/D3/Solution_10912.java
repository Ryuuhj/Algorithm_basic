package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_10912 {
    static int T;
    static String str;
    static int[] freq;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            str = br.readLine();
            freq = new int[26];
            for (int i = 0; i < str.length(); i++) {
                int idx = str.charAt(i) - 'a';
                freq[idx] += 1;
            }
            for (int i = 0; i < freq.length; i++) {
                if (freq[i] % 2 != 0) {
                    sb.append((char) (i + 'a'));
                }
            }
            if(sb.charAt(sb.length()-1) == ' ') sb.append("Good");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
