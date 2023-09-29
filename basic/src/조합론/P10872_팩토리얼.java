package 조합론;

import java.util.Scanner;
import java.util.stream.IntStream;

public class P10872_팩토리얼 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int factorial = 1;
        
        if (N > 1)
            factorial = IntStream.range(1, N + 1).reduce(1, (a, b) -> a * b);
        
        System.out.println(factorial);
    }
}
