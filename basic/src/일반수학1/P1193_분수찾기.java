package 일반수학1;

import java.io.*;

public class P1193_분수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());

        int k = 1, cnt = 1;
        while (cnt < N) {
            k++;
            cnt = (k * (k + 1)) / 2;
        }

        int diff = cnt - N;
        int i = 1, j = 1;
        if (k % 2 == 1) {
            i = 1 + diff;
            j = k - diff;
        } else {
            i = k - diff;
            j = 1 + diff;
        }

        bw.write(i + "/" + j);
        bw.flush();
        bw.close();
    }
}
