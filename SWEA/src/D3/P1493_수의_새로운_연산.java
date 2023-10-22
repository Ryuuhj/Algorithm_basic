package D3;

import java.util.Scanner;

public class P1493_수의_새로운_연산 {
    static int[][] point;
    static int x1, x2, y1, y2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        point = new int[2][50001];
        int n = 1;
        int x = 1, y = 1;
        int idx = 1;
        while (idx <= 10000){
            if (y == 0) {
                n++;
                x = 1; y = n;
            }
            point[0][idx] = x;
            point[1][idx] = y;
            x++; y--;
            idx++;

        }
        //System.out.println("최대 : " + n); -> 좌표 최대
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int p = sc.nextInt();
            int q = sc.nextInt();
            int ans = cal(p, q);
            System.out.printf("#%d %d\n", t+1, ans);
        }

    }

    private static int cal(int p, int q) {
        //1.&연산
        x1 = point[0][p];
        y1 = point[1][p];
        x2 = point[0][q];
        y2 = point[1][q];
        //2. 덧셈
        x1 += x2;
        y1 += y2;
        //3. #연산
        for (int i = 1; i < point[0].length; i++) {
            if (point[0][i] == x1 && point[1][i] == y1) {
                return i;
            }
        }
        return -1;
    }
}
