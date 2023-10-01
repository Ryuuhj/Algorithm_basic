package 재귀단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P4779_칸토어집합 {
    static StringBuilder ans;
    static String input, arr;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            input = br.readLine();
            if (input == null) // 테스트 케이스 마지막
                break;
            N = Integer.parseInt(input);
            ans = new StringBuilder();
            arr = "-".repeat((int)Math.pow(3, N));
            getCantor(arr);
            System.out.println(ans);
        }
    }

    private static void getCantor(String arr) {
        if(arr.length() <= 1) {
            ans.append("-");
            return;
        }
        int mid = arr.length() / 3;
        getCantor(arr.substring(0, mid));
        ans.append(" ".repeat(mid));
        getCantor(arr.substring(mid*2, arr.length()));
    }
}
