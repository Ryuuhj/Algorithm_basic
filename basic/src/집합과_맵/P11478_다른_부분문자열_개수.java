package 집합과_맵;

import java.util.HashSet;
import java.util.Scanner;

public class P11478_다른_부분문자열_개수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        int len = S.length();
        HashSet<String> set = new HashSet<>();
        set.add(S);

        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= len - i; j++) {
                set.add(S.substring(j, j + i));
            }
        }

        System.out.println(set.size());

    }
}
