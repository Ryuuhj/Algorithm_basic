package D3;

import java.util.Scanner;

public class P1215_회문1 {
    static int length;
    static String[] row, col;
    static String[] input;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = 10;
        for (int i = 1; i <= T; i++) {
            length = sc.nextInt();
            input = new String[8];
            int cnt = 0;
            sb.append("#").append(i).append(" ");
            sc.nextLine();
            for (int j = 0; j < 8; j++) {
                input[j] = sc.nextLine();
            }
            //row 기준 검증
            for (int j = 0; j < 8; j++) {
                cnt += countPalindrome(input[j].toCharArray());
            }
            //column 기준 검증
            for (int col = 0; col < 8; col++) {
                char[] tmp = new char[8];
                for (int row = 0; row < 8; row++) {
                    tmp[row] = input[row].charAt(col);
                }
                cnt += countPalindrome(tmp);
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
    private static int countPalindrome(char[] s) {
        int cnt = 0;
        loop1:
        for (int i = 0; i <= 8 - length; i++) {
            int front = i;
            int back = i + length-1;
            for (int j = 0; j < length / 2; j++) {
                if (!(s[front+j]==s[back-j])) {
                    continue loop1;
                }
            }
            cnt++;
        }
        return cnt;
    }

    private static boolean isPalindrome(char[] s) {
        int front = 0, back = length - 1;
        for (int i = 0; i < s.length/2; i++) {
            front += i;
            back -= i;
            if (!(s[front]==s[back])) {
                return false;
            }
        }
        return true;
    }
}
