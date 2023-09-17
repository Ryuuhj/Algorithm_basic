package 브루트포스;

import java.util.Scanner;

public class P1436_영화감독숌 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int k = 666;
        int cnt = 1;
        while (cnt != n) {
            k++;
            if (String.valueOf(k).contains("666")) {
                cnt++;
            }
        }
        System.out.println(k);
    }
}
