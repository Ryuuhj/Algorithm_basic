package 기하_직사각형_삼각형;

import java.util.Scanner;

public class P3009_네번째_점 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] xp = new int[1001];
        int[] yp = new int[1001];
        int x = 0, y = 0;
        for (int i = 0; i < 3; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            xp[x]++;
            yp[y]++;
        }
        int p1 = 0, p2 = 0;
        for (int i = 1; i < xp.length; i++) {
            if (xp[i] % 2 != 0) {
                p1 = i;
            }
            if (yp[i] % 2 != 0) {
                p2 = i;
            }
        }
        System.out.println(p1 + " " + p2);
    }
}
