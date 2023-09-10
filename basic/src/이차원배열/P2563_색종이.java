package 이차원배열;

import java.util.Scanner;

public class P2563_색종이 {
    static int[][] bg;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        bg = new int[101][101];
        int N = sc.nextInt();
        int area = 0;

        int x = 0, y = 0;
        while (N-- > 0) {
            x = sc.nextInt();
            y = sc.nextInt();
            fill(x, y);
        }
        for (int[] line : bg) {
            for (int o : line) {
                area += o;
            }
        }
        System.out.println(area);

    }

    private static void fill(int r, int c) {
        for (int i = r+1; i <= r + 10; i++) {
            for (int j = c + 1; j <= c + 10; j++) {
                bg[i][j] = 1;
            }
        }
    }
}
