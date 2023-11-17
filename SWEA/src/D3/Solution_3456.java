package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_3456 {
    static int T, side;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (num[1] != num[0]) {
                if(num[1] == num[2]) side = num[0];
                else side = num[1];
            }else
                side = num[2];
            System.out.printf("#%d %d\n", t, side);
        }
    }
}
