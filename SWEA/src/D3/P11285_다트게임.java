package D3;

import java.util.Scanner;

public class P11285_다트게임 {
    static int[] sq = new int[]{-1, 20 * 20, 40 * 40, 60 * 60, 80 * 80, 100 * 100, 120 * 120, 140 * 140, 160 * 160, 180 * 180, 200 * 200};
    static int[] points = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    static int N, x, y;
    static long score;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            score = 0;
            while (N-- > 0) {
                x = sc.nextInt();
                y = sc.nextInt();
                score += getScore(x, y);
            }
            sb.append("#" + t + " " + score + "\n");
        }
        System.out.println(sb);
    }

    private static long getScore(int x, int y) {
        int xy = x * x + y * y;
        for (int i = 0; i < sq.length - 1; i++) {
            if (sq[i] < xy && xy <= sq[i + 1]) {
                return points[i];
            }
        }
        return 0;
    }
}
