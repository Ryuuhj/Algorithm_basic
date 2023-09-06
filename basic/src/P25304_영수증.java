import java.util.Scanner;

public class P25304_영수증 {
    static int a, b;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long X = sc.nextLong();
        int N = sc.nextInt();
        long real = 0;
        while (N-- > 0) {
            a = sc.nextInt();
            b = sc.nextInt();
            real += (a * b);
        }

        if (X == real) {
            System.out.println("Yes");
        }else
            System.out.println("No");
    }
}
