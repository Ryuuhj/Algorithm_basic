package 기하_직사각형_삼각형;

import java.util.Scanner;

public class P1085_직사각형에서_탈출 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int wm = Math.min(x, w - x);
        int hm = Math.min(y, h - y);

        System.out.println(Math.min(wm, hm));
    }
}
