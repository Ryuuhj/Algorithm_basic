package D3;

import java.io.*;

public class Solution_1289 {
    //홀수번 고쳐야 반대로 돌아감
    static int T, changeCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String str = br.readLine();
            changeCnt = str.charAt(0) == '0' ? 0 : 1;
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i - 1) != str.charAt(i)) {
                    changeCnt++;
                }
            }
            bw.write("#" + t + " " + changeCnt + "\n");
        }
        bw.flush();
        bw.close();
    }
}
