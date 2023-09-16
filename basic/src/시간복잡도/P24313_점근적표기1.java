package 시간복잡도;

import java.util.Scanner;

public class P24313_점근적표기1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a1 = sc.nextInt();
        int a0 = sc.nextInt();
        int c = sc.nextInt();
        int n0 = sc.nextInt();
        //int ans = (a0 <= (c - a1) * n0) ? 1 : 0;
        if (c - a1 >= 0)
            System.out.println((a0 <= (c - a1) * n0) ? 1 : 0);
        else
            System.out.println(0);
    }
}
