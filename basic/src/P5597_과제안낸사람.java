import java.util.Scanner;

public class P5597_과제안낸사람 {
    static int input;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] check = new boolean[31];

        int submit = 28;
        while (submit-- > 0) {
            input = sc.nextInt();
            check[input] = true;
        }
        for (int i = 1; i <=30 ; i++) {
            if (!check[i]) {
                System.out.println(i);
            }
        }
    }
}
