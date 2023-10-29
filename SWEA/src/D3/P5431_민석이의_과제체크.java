package D3;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class P5431_민석이의_과제체크 {
    static int N, K, s;
    static ArrayList<Integer> notPermit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            K = sc.nextInt();
            notPermit = new ArrayList<>();
            IntStream.range(1, N + 1).forEach((e) -> notPermit.add(e));
            while (K-- > 0) {
                s = sc.nextInt();
                notPermit.remove(Integer.valueOf(s));
            }
            sb.append("#" + t + " ");
            for (int n : notPermit) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
