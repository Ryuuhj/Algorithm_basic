package 정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P10989_수_정렬하기3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[10001];
        int k = 0;
        for (int i = 0; i < N; i++) {
            k = Integer.parseInt(br.readLine());
            cnt[k]++;
        }
        for (int i = 1; i < cnt.length; i++) {
            if (cnt[i] > 0) {
                for (int j = 0; j < cnt[i]; j++) {
                    bw.write(i + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
