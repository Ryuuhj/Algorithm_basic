package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1989_초심자의_회문_검사 {
    static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");
            str = br.readLine().trim();
            int h = 0, r = str.length()-1;
            boolean flag = true;
            while (h < r) {
                if (str.charAt(h) != str.charAt(r)) {
                    flag = false;
                    break;
                }
                h++; r--;
            }
            if(flag)
                sb.append("1\n");
            else sb.append("0\n");
        }
        System.out.println(sb);
    }
}
