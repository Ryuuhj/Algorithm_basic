package D2;

import java.util.Arrays;
import java.util.Scanner;

public class P1926_간단한369게임 {
    static int N, cnt;
    static String trans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            trans = String.valueOf(i);
            cnt = (int) Arrays.stream(trans.split(""))
                    .filter(s -> (s.equals("3")||s.equals("6")||s.equals("9"))).count();
            if(cnt > 0) {
                for (int j = 0; j < cnt; j++) {
                    sb.append("-");
                }
            }
            else
                sb.append(trans);
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
