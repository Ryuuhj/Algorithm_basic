package 기하_직사각형_삼각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9063_대지 {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        if (n == 1) {
            System.out.println(0);
            return;
        }
        int a = 0, b = 0;
        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y2 = Integer.MIN_VALUE;

        while (n-- > 0) {
            st = new StringTokenizer(bf.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            x1 = Math.min(x1, a);
            y1 = Math.min(y1, b);
            x2 = Math.max(x2, a);
            y2 = Math.max(y2, b);
        }
        long area = (long) (x2 - x1) * (y2 - y1);
        System.out.println(area);

    }
}
