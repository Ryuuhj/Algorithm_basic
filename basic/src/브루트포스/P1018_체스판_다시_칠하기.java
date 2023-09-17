package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1018_체스판_다시_칠하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[][] arr = new String[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().split("");
        }
        int ans = Integer.MAX_VALUE;

        for (int n = 0; n < N - 7; n++) {
            for (int m = 0; m < M - 7; m++) {
                int cnt = 0;
                for (int i = n; i < n + 8; i++) {
                    for (int j = m; j < m + 8; j++) {
                        if ((i + j) % 2 == 0) {
                            if (arr[i][j].equals("B"))
                                cnt++;

                        } else {
                            if (arr[i][j].equals("W"))
                                cnt++;

                        }
                    }
                }
                cnt = Math.min(cnt, 64 - cnt);
                ans = Math.min(ans, cnt);
            }
        }
        System.out.println(ans);
    }
}
