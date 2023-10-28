package D3;

import java.io.*;
import java.util.StringTokenizer;

public class P13038_교환학생 {
    static StringTokenizer st;
    static int n, min, len;
    //static ArrayList<Integer> schedule;
    static int[] schedule;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            schedule = new int[8];
            len = 0; min = Integer.MAX_VALUE;

            for (int i = 1; i <= 7; i++) {
                schedule[i] = Integer.parseInt(st.nextToken());
                if(schedule[i] == 1)
                    len++;
            }

            for (int i = 1; i <= 7; i++) {
                if(schedule[i] == 1)
                    getDates(i);
            }
            bw.write("#" + t + " " + min + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void getDates(int idx) {
        int sum = 0, remainder = 0;
        if (len == 7) {
            sum = n;
        }
        else {
            if (len == 1) {
                sum = (n - 1) * 7 + 1;
            } else {
                if(len >= n){
                    remainder = n;}
                else {
                    sum = ((n / len)-1) * 7;
                    remainder = n % len + len;
                }
                while (remainder > 0) {
                    if (schedule[idx] == 1) {
                        remainder--;
                    }
                    sum++;
                    idx = (idx == 7) ? 1 : idx + 1;
                }
            }
        }
        min = Math.min(min, sum);
    }
}
