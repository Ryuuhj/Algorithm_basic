package 기하_직사각형_삼각형;

import java.util.Scanner;

public class P10101_삼각형_외우기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a1 = sc.nextInt();
        int a2 = sc.nextInt();
        int a3 = sc.nextInt();
        int sum = a1 + a2 + a3;

        if (sum != 180) {
            System.out.println("Error");
        } else {
            if (a1 == a2 && a1 == a3) {
                System.out.println("Equilateral");
            } else if ((a1 != a2 && a2 != a3) && a1 != a3) {
                System.out.println("Scalene");
            } else {
                System.out.println("Isosceles");
            }
        }
    }
}
