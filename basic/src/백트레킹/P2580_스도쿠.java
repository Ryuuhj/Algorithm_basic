package 백트레킹;

import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

public class P2580_스도쿠 {
    static int[][] sudoku = new int[9][9];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            sudoku[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        fillSudoku(0, 0);


    }

    private static void fillSudoku(int row, int col) {

        if (col == 9) {
            fillSudoku(row + 1, 0);
            return;
        }

        if (row == 9) {
            for (int[] s : sudoku) {
                for (int e : s) {
                    sb.append(e).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        if (sudoku[row][col] == 0) {
            for (int k = 1; k <= 9; k++) {
                if (isPossible(row, col, k)) {
                    sudoku[row][col] = k;
                    fillSudoku(row, col + 1);
                }
                //여기서는 0으로 초기화 해 줄 필요 없음 어차피 이전 수와 다른 수 들어가므로
            }
            sudoku[row][col] = 0; //불가능한 카드일 경우-> 출력 없이 재귀함수 빠져나와 밑으로 내려옴 => 초기화 하고 끝
            return;
        }
        fillSudoku(row, col + 1);
    }

    private static boolean isPossible(int row, int col, int val) {
        for (int i = 0; i < 9; i++) {
            if(val == sudoku[row][i])
                return false;
            else if (val == sudoku[i][col]) {
                return false;
            }
        }
        int sRow = (row / 3) * 3;
        int sCol = (col / 3) * 3;

        for (int i = sRow; i < sRow + 3; i++) {
            for (int j = sCol; j < sCol + 3; j++) {
                if (sudoku[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}
