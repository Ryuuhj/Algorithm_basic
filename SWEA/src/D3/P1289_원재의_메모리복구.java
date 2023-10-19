package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1289_원재의_메모리복구 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String[] origin = br.readLine().split("");
            String comp = "0";
            int cnt = 0;
            for (int i = 0; i < origin.length; i++) {
                if (!origin[i].equals(comp)) {
                    comp = origin[i];
                    cnt++;
                }
            }
            System.out.printf("#%d %d\n", t, cnt);
        }
    }


}
