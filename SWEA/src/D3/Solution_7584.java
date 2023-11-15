package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_7584 {
    static int T, ans;
    static long K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            K = Long.parseLong(br.readLine());
            ans = getChar(K-1);
            System.out.printf("#%d %d\n", t, ans);
        }
    }

    private static int getChar(long k) {
        //4의 배수
        if(k % 4 == 0)
            return 0;
        else if (k % 2 == 0) {
            return 1;
        }//홀수인 경우 => f((n-1)/2)
        return getChar((k - 1) / 2);
    }
}
