import java.util.Scanner;

public class P2444_별찍기7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder output = new StringBuilder();
        int N = sc.nextInt();
        String space = " ";
        String star = "*";
        for (int i = 1; i <= N; i++) {
            output.append(space.repeat(N - i) + star.repeat(2 * i - 1) + "\n");
        }
        //거꾸로
        for (int i = N - 1; i >= 1; i--) {
            output.append(space.repeat(N - i) + star.repeat(2 * i - 1) + "\n");
        }
        System.out.println(output);
    }
}
