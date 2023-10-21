package D3;

import java.util.Scanner;

public class P2806_N_Queen {
    static int[] queen;
    static int cnt;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //dfs 백트래킹
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            queen = new int[N+1];
            cnt = 0;
            countQueen(1);
            System.out.printf("#%d %d\n", t, cnt);
        }
    }
    private static void countQueen(int row) {
        if (row == N + 1) {
            cnt++;
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (isPossible(row, i)) {
                queen[row] = i;
                countQueen(row + 1);
            }
        }
    }

    private static boolean isPossible(int row, int col) {
        for (int i = 1; i < row; i++) {
            if(queen[i] == col) //같은 col에 있으면 안됨
                return false;
            if ((queen[i] - i) == (col-row) || (queen[i] + i) == (row + col)){
                return false;
            }
        }
        return true;
    }
}
