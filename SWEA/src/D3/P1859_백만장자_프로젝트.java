package D3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1859_백만장자_프로젝트 {
    static long profit, cost;
    static int cnt, maxPrice, N;
    static int[] price;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            price = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }

            profit = 0;
            getProfit(0);
            bw.write("#" + (t + 1) + " " + profit + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void getProfit(int start) {
        if (start < (N - 1)) {
            maxPrice = Arrays.stream(Arrays.copyOfRange(price, start, N)).max().getAsInt();
            for (int i = start; i < N; i++) {
                if (price[i] == maxPrice) {
                    cost = Arrays.stream(Arrays.copyOfRange(price, start, i)).sum();
                    cnt = i - start;
                    profit += ((long) maxPrice * cnt - cost);
                    getProfit(i + 1);
                    return;
                }
            }
        }
    }
}
