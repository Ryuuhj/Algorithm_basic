package D2;

import java.util.Scanner;

public class P1948_날짜_계산기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] dates = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int test_case = 1; test_case <= T; test_case++) {
            int M1 = sc.nextInt();
            int D1 = sc.nextInt();
            int M2 = sc.nextInt();
            int D2 = sc.nextInt();
            int total = 0;
            for (int i = M1; i < M2; i++) {
                total += dates[i];
            }
            total += (D2 - D1 + 1);
            System.out.println("#" + test_case + " " + total);
        }
    }
}
