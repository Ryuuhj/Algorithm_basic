package 시간복잡도;

import java.util.Scanner;

public class P24267_수행시간6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println((long) n * (n - 1) * (n - 2) / 6);
        System.out.println(3);
    }
}
