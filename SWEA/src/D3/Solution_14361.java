package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution_14361 {
    static int T, N;
    static String input, kN;
    static Set<Integer> origin, tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            input = br.readLine();
            N = Integer.parseInt(input);
            List<Integer> nums = Arrays.stream(input.split("")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
            origin = new HashSet<>(nums);

            String ans = "impossible";

            for (int i = 2; i < 10; i++) {
                kN = String.valueOf(i * N);
                tmp = new HashSet<>(Arrays.stream(kN.split("")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList()));
                if(origin.equals(tmp))
                    ans = "possible";
            }
            System.out.printf("#%d %s\n", t, ans);
        }
    }
}
