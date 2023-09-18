package 정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P11652_카드 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N + 1];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr, 0, N); //exclusive -> N

        int cnt = 0;
        long ans = 0, max = Long.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            cnt++;
            if (max < cnt) {
                max = cnt;
                ans = arr[i];
            }
            if ((arr[i] != arr[i + 1]) || (i == N - 1)) {
                cnt = 0;
            }
        }

        System.out.println(ans);


    }
}
