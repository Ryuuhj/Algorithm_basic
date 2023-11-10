package D3;

import java.io.*;
import java.util.StringTokenizer;

public class P5215_햄버거_다이어트 {
    static int N, L;
    static int maxValue;
    static Ingredient[] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //재료 개수
            L = Integer.parseInt(st.nextToken()); //칼로리 제한 (이하)

            arr = new Ingredient[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i] = new Ingredient(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            maxValue = Integer.MIN_VALUE;

            getMax(0, 0, L);
            bw.write("#" + t + " " + maxValue + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void getMax(int idx, int score, int cal) {
        if (cal < 0) {
            return;
        }
        if(idx == N){
            maxValue = Math.max(maxValue, score);
            return;
        }
        getMax(idx + 1, score + arr[idx].score, cal - arr[idx].calorie);
        getMax(idx + 1, score , cal);
    }
    private static class Ingredient{
        int score;
        int calorie;

        Ingredient(int score, int calorie) {
            this.score = score;
            this.calorie = calorie;
        }
    }
}
