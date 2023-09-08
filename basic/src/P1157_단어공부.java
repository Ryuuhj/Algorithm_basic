import java.util.Arrays;
import java.util.Scanner;

public class P1157_단어공부 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] word = sc.nextLine().toUpperCase().toCharArray();
        int[] cnt = new int[26];
        for (int i = 0; i < word.length; i++) {
            cnt[(int) word[i] - 'A']++;
        }
        int max = Arrays.stream(cnt).max().getAsInt();
        char ans = ' ';
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == max) {
                if (ans != ' ') {
                    System.out.println("?");
                    return;
                } else {
                    ans = (char) (i + (int) 'A');
                }
            }
        }
        System.out.println(ans);

    }
}
