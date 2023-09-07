import java.util.Scanner;

public class P2562_최댓값 {
    final static int N = 9;
    static int input;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = 0;
        int maxIdx = 0;
        for (int i = 1; i <= N; i++) {
            input = sc.nextInt();
            if (max < input) {
                max = input;
                maxIdx = i;
            }
        }
        System.out.println(max);
        System.out.println(maxIdx);
    }
}
