package 정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P15688_수_정렬하기5 {
    static int[] freq = new int[2000001];
    static int N, num;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            num = Integer.parseInt(br.readLine());
            freq[num + 1000000]++;
        }

        for (int i = 0; i < 1000000; i++) {
            while (freq[i] > 0) {
                bw.write((i-1000000) + "\n");
                freq[i]--;
            }
        }
        for (int i = 1000000; i <= 2000000; i++) {
            while (freq[i] > 0) {
                bw.write((i-1000000) + "\n");
                freq[i]--;
            }
        }
        bw.flush();
        bw.close();
    }
}
