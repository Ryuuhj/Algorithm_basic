package 일반수학1;

import java.util.Scanner;

public class P2745_진법변환 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] N = sc.next().toCharArray();
        int length = N.length;
        int B = sc.nextInt();

        long ans = 0;
        int tmp = 0;

        for (int i = 0; i < length; i++) {
            if ((int) N[i] >= 65) {
                tmp = (int) N[i] - 55;
            }else {
                tmp = N[i] - '0';
            }
            ans += tmp * Math.pow(B, length - (i + 1));
        }
        System.out.println(ans);

    }
}
