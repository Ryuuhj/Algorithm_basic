package 이차원배열;

import java.io.*;

public class P10798_세로읽기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[][] input = new String[5][15];
        int maxL = 0;

        for (int i = 0; i < 5; i++) {
            String[] tmp = bf.readLine().split("");
            maxL = Math.max(maxL, tmp.length);
            input[i] = tmp;
        }

        //세로로 읽기
        for (int i = 0; i < maxL; i++) {
            for (int j = 0; j < 5; j++) {
                if (input[j].length > i) {
                    bw.write(input[j][i]);
                }
            }
        }
        bw.close();
    }
}
