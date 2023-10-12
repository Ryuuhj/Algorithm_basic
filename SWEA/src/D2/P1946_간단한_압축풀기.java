package D2;

import java.io.*;

public class P1946_간단한_압축풀기 {
    static String[] input;
    static int N;
    static StringBuilder tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++){
            sb.append("#").append(test_case).append("\n");
            tmp = new StringBuilder();

            N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                input = br.readLine().split(" ");
                tmp.append(input[0].repeat(Integer.parseInt(input[1])));
                if (tmp.length() > 10) {
                    sb.append(tmp.substring(0,10)).append("\n");
                    tmp.delete(0, 10);
                }
            }
            sb.append(tmp).append("\n");
        }
        System.out.println(sb);
    }
}
