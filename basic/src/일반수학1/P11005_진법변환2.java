package 일반수학1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.IntStream;

public class P11005_진법변환2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Character> map = new HashMap<>();
        IntStream.range(10, 36).forEach(e -> map.put(e, (char) (e + 55)));

        int N = sc.nextInt();
        int B = sc.nextInt();
        int length = (int) getLog(N, B);
        int tmpB = 0, q = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = length; i >= 0; i--) {
            tmpB = (int)Math.round(Math.pow(B, i));
            q = N / tmpB;
            if(q >= 10)
                sb.append(map.get(q));
            else if (q != 0 || sb.length() > 0) {
                sb.append(q);
            }
            N %= tmpB;
        }
        System.out.println(sb);

    }
    private static double getLog(double x, double base) {
        return Math.log10(x) / Math.log10(base);
    }
}
