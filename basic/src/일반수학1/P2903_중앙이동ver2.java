package 일반수학1;

import java.util.Scanner;

public class P2903_중앙이동ver2 {
    //N회 => (2^N+1)^2
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = (int) Math.pow(Math.pow(2, n) + 1, 2);
        System.out.println(result);
    }
}
