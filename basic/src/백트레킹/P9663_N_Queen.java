package 백트레킹;

import java.util.Scanner;

public class P9663_N_Queen {
    static int[] queen;
    static int cnt = 0 , N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        queen = new int[N];

        getQueen(0);
        System.out.println(cnt);
    }

    private static void getQueen(int row) {
        if (row == N) {
            cnt++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (putQueen(row, i)) {
                queen[row] = i;
                getQueen(row + 1);
            }
        }
    }

    private static boolean putQueen(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queen[i] == col)
                return false;
        }
        for (int i = 0; i < row; i++) {
            if ((row - i) == Math.abs(queen[i] - col))
                return false;
        }
        return true;
    }
}
