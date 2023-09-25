package 약수_배수_소수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P13909_창문_닫기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int ans = (int) Math.sqrt(n);
        sb.append(ans);
        System.out.println(sb);
    }
}
