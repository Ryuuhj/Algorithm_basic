package 약수_배수_소수;

import java.util.Scanner;

public class P11653_소인수분해 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N == 1)
            return;

        StringBuilder sb = new StringBuilder();

        outer:
        for (int i = 2; i <= N; i++) {
            while (N % i == 0) {
                sb.append(i).append("\n");
                N /= i;
                if (N == 0)
                    break outer;
            }
        }

        System.out.println(sb);
    }
}
