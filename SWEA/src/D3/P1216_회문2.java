package D3;

import java.io.*;

public class P1216_회문2 {
    static char[][] board;
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = 10;
        for (int t = 1; t <= T; t++) {
            k = Integer.parseInt(br.readLine());
            board = new char[100][100];
            for (int i = 0; i < 100; i++) {
                board[i] = br.readLine().toCharArray();
            }
            bw.write("#" + k + " ");
            bw.write(getMaxLength(board) + "\n");

        }
        bw.flush();
        bw.close();

    }

    private static int getMaxLength(char[][] board) {
        int colMax = 100, rowMax = 100;
        //세로줄 검사
        loop1:
        while (colMax > 1) {
            for (int c = 0; c < 100; c++) {
                StringBuilder tmp = new StringBuilder();
                for (int r = 0; r < 100; r++) {
                    tmp.append(board[r][c]);
                    if(tmp.length() > colMax)
                        tmp.delete(0, 1);
                    if (tmp.length() == colMax && isPalindrome(tmp))
                        break loop1;
                }
            }
            colMax--;
        }
        loop2:
        while (rowMax >= colMax) {
            for (int r = 0; r < 100; r++) {
                StringBuilder tmp = new StringBuilder();
                for (int c = 0; c < 100; c++) {
                    tmp.append(board[r][c]);
                    if(tmp.length() > rowMax)
                        tmp.delete(0, 1);
                    if (tmp.length() == rowMax && isPalindrome(tmp))
                        break loop2;
                }
            }
            rowMax--;
        }
        return Math.max(rowMax, colMax);
    }

    private static boolean isPalindrome(StringBuilder tmp) {
        int front = 0, rear = tmp.length() - 1;
        while (front <= rear) {
            if (tmp.charAt(front) != tmp.charAt(rear))
                return false;
            front++;
            rear--;
        }
        return true;
    }
}
