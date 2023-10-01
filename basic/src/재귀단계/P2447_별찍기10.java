package 재귀단계;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class P2447_별찍기10 {
    static StringBuilder sb;
    static char[][] ans;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        ans = new char[N][N];
        sb = new StringBuilder();
        printStar(N, 0, 0);
        for (char[] cs : ans) {
            for (char c : cs) {
                sb.append(c + "");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void printStar(int n, int r, int c) {
        if (n == 3) {
            for (int i = r; i < r + 3; i++) {
                for (int j = c; j < c + 3; j++) {
                    if (i == r + 1 && j == c + 1)
                        ans[i][j] = ' ';
                    else
                        ans[i][j] = '*';
                }
            }
            return;
        }
        int unit = n / 3;
        for (int i = r; i <= r + (unit * 2); i += unit) {
            for (int j = c; j <= c + (unit * 2); j += unit) {
                if (i == r + unit && j == c + unit) {
                    for (int k = i; k < i + unit; k++) {
                        for (int l = j; l <j+unit ; l++) {
                            ans[k][l] = ' ';
                        }
                    }
                } else
                    printStar(unit, i, j);
            }
        }

    }

}
