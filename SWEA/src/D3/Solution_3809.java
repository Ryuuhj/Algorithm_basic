package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_3809 {
    static int T, N, ans;
    static String[] str;
    static String num, origin;
    static StringBuilder st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            st = new StringBuilder();
            while (st.length() != N){
                str = br.readLine().split(" ");
                for (int j = 0; j < str.length; j++) {
                    st.append(str[j]);
                }
            }
            origin = st.toString();
            for (int i = 0; i <= 1000; i++) {
                num = String.valueOf(i);
                if (!origin.contains(num)) {
                    ans = i;
                    break;
                }
            }
            System.out.printf("#%d %d\n",t, ans);
        }
    }
}
