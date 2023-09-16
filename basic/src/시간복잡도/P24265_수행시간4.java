package 시간복잡도;

import java.util.Scanner;

public class P24265_수행시간4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n % 2 == 0) {
            System.out.println((long) n * (n / 2 - 1) + n / 2);
        } else {
            System.out.println((long) n * (n - 1) / 2);
        }
        System.out.println(2);
    }
}
