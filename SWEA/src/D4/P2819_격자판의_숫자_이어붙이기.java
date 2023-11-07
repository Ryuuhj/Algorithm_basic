package D4;

import java.io.*;
import java.util.*;

public class P2819_격자판의_숫자_이어붙이기 {
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static String[][] board;
    static Set<String> set;
    static int nx, ny;
    static String nNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            board = new String[4][4];
            set = new HashSet<>();

            for (int i = 0; i < 4; i++) {
                board[i] = br.readLine().split(" ");
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    dfs(i, j, board[i][j]);
                }
            }
            bw.write("#" + t + " " + set.size() + "\n");
        }
        bw.close();
    }

    private static void dfs(int i, int j, String str) {

        for (int k = 0; k < 4; k++) {
            nx = i + dx[k];
            ny = j + dy[k];
            if(nx < 0 || ny < 0 || nx >= 4 || ny >= 4) continue;
            nNum = str + board[nx][ny];
            if (nNum.length() == 7) {
                set.add(nNum);
                continue;
            }
            dfs(nx, ny, nNum);
        }
    }

}
