package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_8556 {
    static int T, dir,dm;
    static String[] dirs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            dirs = br.readLine().split("th|st");
            dir = dirs[dirs.length-1].equals("nor") ? 0 : 90;
            dm = 1;
            for (int i = dirs.length-2; i >= 0; i--) {
                dir *= 2;
                dm *= 2;
                if(dirs[i].equals("nor")) dir -= 90;
                else dir += 90;
            }
            while (dir % 2 == 0 && dm % 2 == 0) {
                dir /= 2;
                dm /= 2;
            }
            if (dm == 1) {
                System.out.printf("#%d %d\n", t, dir);
            }else
                System.out.printf("#%d %d/%d\n", t, dir, dm);
        }
    }
}
