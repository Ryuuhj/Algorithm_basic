package 재귀단계;

import java.io.*;

public class P25501_재귀의귀재 {
    static int cnt, ans;
    static String s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            cnt = 0;
            s = br.readLine();
            ans = isPalindrome(s, 0, s.length() - 1);
            bw.write(ans + " " + cnt + "\n");
        }
        bw.close();
    }
    private static int isPalindrome(String s, int l, int r) {
        cnt++;
        if(l >= r)
            return 1;
        if (s.charAt(l) != s.charAt(r))
            return 0;
        else
            return isPalindrome(s, l + 1, r - 1);
    }
}
