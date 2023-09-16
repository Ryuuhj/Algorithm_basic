package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2798_블랙잭 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] card = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int max = 0;

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (card[i] + card[j] + card[k] <= M) {
                        max = Math.max(max, card[i] + card[j] + card[k]);
                    }
                }
            }
        }
        System.out.println(max);

    }
}
