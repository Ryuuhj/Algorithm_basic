package D3;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1230_암호문3 {
    final static int T = 10;
    static ArrayList<Integer> password;
    static String cmd;
    static int t1, t2;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            password = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (N-- > 0) {
                password.add(Integer.parseInt(st.nextToken()));
            }
            int cmdCnt = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            while (cmdCnt-- > 0) {
                cmd = st.nextToken();
                t1 = Integer.parseInt(st.nextToken());
                modifyPW(cmd, t1, st);
            }
            bw.write("#"+t+" ");
            for (int i = 0; i < 10; i++) {
                bw.write(password.get(i)+" ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
    private static void modifyPW(String cmd, int t1, StringTokenizer st) {
        switch (cmd) {
            case "I":
                t2 = Integer.parseInt(st.nextToken()); //t1= x, t2 = y

                while (t2-- > 0) {
                    password.add(t1++, Integer.parseInt(st.nextToken()));
                }
                break;
            case "D":
                t2 = Integer.parseInt(st.nextToken());
                while (t2-- > 0) {
                    password.remove(t1);
                }
                break;
            case "A":  //t1 = y
                while (t1-- > 0) {
                    password.add(Integer.parseInt(st.nextToken()));
                }
                break;
        }
    }
}
