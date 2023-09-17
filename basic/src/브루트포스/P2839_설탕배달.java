package 브루트포스;

import java.util.Scanner;

public class P2839_설탕배달 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0, r = 0;
        for (int i = n / 5; i >= 0; i--) {
            r = n - 5 * i;
            if (r % 3 == 0) {
                ans = i + r / 3;
                break;
            }
        }
        if (ans == 0) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
}
