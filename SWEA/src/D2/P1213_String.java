package D2;

import java.util.Scanner;

public class P1213_String {
    static int T = 10;
    static int N;
    static StringBuilder sb = new StringBuilder();
    static String input, word;
    static String[] result;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = 10;
        //2개 포함되어 있으면 기준으로 분할하는 경우 -> 3분할
        //맨앞, 맨 뒤에 포함된 경우 고려해 앞, 뒤에 111 붙일 것
        for (int i = 1; i <=T; i++) {
            sc.nextLine();
            sb.append("#").append(i).append(" ");
            word = sc.nextLine();
            input = "111" + sc.nextLine() + "111";

            result = input.split(word);
            //개수 = 길이 -1
            sb.append(result.length - 1).append("\n");
        }
        System.out.println(sb);
    }
}
