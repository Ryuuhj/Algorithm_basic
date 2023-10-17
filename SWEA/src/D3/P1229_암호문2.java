package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1229_암호문2 {
    final static int T = 10;
    static ArrayList<Integer> pw;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            pw = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (N-- > 0) {
                pw.add(Integer.parseInt(st.nextToken()));
            }
            int cmdCount = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            while (cmdCount-- > 0) {
                String cmd = st.nextToken();
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                modPW(cmd, x, y, st);
            }
            //결과 출력
            sb.append("#").append(t).append(" ");
            for (int i = 0; i < 10; i++) {
                sb.append(pw.get(i)).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void modPW(String cmd, int x, int y, StringTokenizer st) {
        if (cmd.equals("I")) {
            while (y-- > 0) {
                pw.add(x++, Integer.parseInt(st.nextToken()));
            }
        } else if (cmd.equals("D")) {
            while (y-- > 0) {
                pw.remove(x);
            }
        }
    }
}
