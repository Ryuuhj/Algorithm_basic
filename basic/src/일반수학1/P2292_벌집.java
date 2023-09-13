package 일반수학1;

import java.util.Scanner;

public class P2292_벌집 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int layer = 1, rooms = 2;

        if (N == 1) {
            System.out.println(1);
        } else {
            while (rooms <= N) {
                rooms += 6 * layer;
                layer++;
            }
            System.out.println(layer);
        }
    }
}
