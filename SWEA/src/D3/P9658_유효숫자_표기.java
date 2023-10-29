package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class P9658_유효숫자_표기 {
    static ArrayList<String> num;
    static int a, b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");
            String str = br.readLine();
            num = (ArrayList<String>) Arrays.stream(str.split("")).collect(Collectors.toList());
            int ex = num.size() - 1;
            a = Integer.parseInt(num.get(0));
            b = Integer.parseInt(num.get(1));
            if (Integer.parseInt(num.get(2)) >= 5) {
                if (b + 1 >= 10) {
                    if (a + 1 < 10) {
                        sb.append(a + 1).append(".").append("0");
                    } else {
                        ex++;
                        sb.append("1.0");
                    }
                }else
                    sb.append(a + "." +(b + 1));
            } else {
                sb.append(a + "." + b);
            }
            sb.append("*10^").append(ex).append("\n");
        }
        System.out.println(sb);
    }
}
