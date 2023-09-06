import java.util.Arrays;
import java.util.Scanner;

public class P2480_주사위_세개 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int sameDE = 0;
        int cnt = 0;
        int prize = 0;

        if (a == b) {
            sameDE = a;
            cnt++;
        }
        if (a == c) {
            sameDE = a;
            cnt++;
        }
        if (b == c) {
            sameDE = b;
            cnt++;
        }

        if (cnt == 3) { //주사위 모두 동일
            prize = 10000 + sameDE * 1000;
        } else if (cnt == 1) { //주사위 2개만 동일
            prize = 1000 + sameDE * 100;
        }else {
            prize = getMax(a, b, c) * 100;
        }

        System.out.println(prize);
    }

    private static int getMax(int...nums) {
        int max = 0;
        for (int n : nums) {
            max = Math.max(max, n);
        }
        return max;
    }
}
