package 브루트포스;

import java.io.*;
import java.util.StringTokenizer;

public class P19532_수학은_비대면강의 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        /*int x = (b * f - c * e) / (b * d - a * e);
        int y = (c * d - a * f) / (b * d - a * e);
        bw.write(x + " " + y);
        bw.close();*/
        for (int x = -999; x < 1000; x++) {
            for (int y = -999; y < 1000; y++) {
                if ((a * x + b * y == c) && (d * x + e * y == f)) {
                    bw.write(x + " " + y);
                    break;
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
