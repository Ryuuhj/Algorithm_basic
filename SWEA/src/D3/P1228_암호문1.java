package D3;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1228_암호문1 {
    final static int T = 10;
    static StringTokenizer st;
    static ArrayList<Integer> pw;
    static String[] cmds;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            pw = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                pw.add(Integer.parseInt(st.nextToken()));
            }
            //3.명령어 개수
            int cmd = Integer.parseInt(br.readLine());
            cmds = br.readLine().split("I ");
            for (int i = 1; i <= cmd; i++) {
                st = new StringTokenizer(cmds[i]);
                int idx = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                for (int j = 0; j < cnt; j++) {
                    pw.add(idx++, Integer.parseInt(st.nextToken()));
                }
            }
            //출력
            sb.append("#").append(t).append(" ");
            for (int i = 0; i < 10; i++) {
                sb.append(pw.get(i)).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
