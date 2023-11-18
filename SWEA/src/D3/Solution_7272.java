package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7272 {
    static int T;
    static String[] input, input2;
    static String ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            input = br.readLine().split(" ");
            ans = "SAME";
            if (input[0].length() == input[1].length()) {
                for (int i = 0; i < input[0].length(); i++) {
                    if (getChar(input[0].charAt(i)) != getChar(input[1].charAt(i))) {
                        ans = "DIFF";
                        break;
                    }
                }
            }else
                ans = "DIFF";
            System.out.printf("#%d %s\n", t, ans);
        }
    }

    private static int getChar(char c) {
        switch (c) {
            case 'B': return 2;
            case 'A': case 'D': case 'O': case 'P': case 'Q': case 'R': return 1;
            default: return 0;
        }
    }
}
