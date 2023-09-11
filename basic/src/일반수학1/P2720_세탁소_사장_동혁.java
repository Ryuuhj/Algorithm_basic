package 일반수학1;

import java.io.*;

public class P2720_세탁소_사장_동혁 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(bf.readLine());
        int[] coin = {25, 10, 5, 1}; //쿼터, 다임, 니켈, 페니 센트 변환
        int C = 0, cnt = 0;

        while (T-- > 0) {
            C = Integer.parseInt(bf.readLine());
            for (int i = 0; i < coin.length; i++) {
                cnt = C / coin[i];
                C %= coin[i];
                bw.write(cnt + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
