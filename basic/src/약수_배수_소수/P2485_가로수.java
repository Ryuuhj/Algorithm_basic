package 약수_배수_소수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2485_가로수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] exist = new int[N];

        int t1 = Integer.parseInt(br.readLine());
        int t2 = Integer.parseInt(br.readLine());
        exist[0] = t1;
        exist[1] = t2;

        int minGap = t2 - t1;
        int now = t2, next = 0;

        for (int i = 2; i < N; i++) {
            next = Integer.parseInt(br.readLine());
            exist[i] = next;
            minGap = getGcp(Math.max(minGap, next - now), Math.min(minGap, next - now));
            now = next;
        }
        int cnt = 0;
        for (int i = 0; i < N-1; i++) {
            cnt += (exist[i + 1] - exist[i]) / minGap - 1;
        }
        System.out.println(cnt);

    }

    private static int getGcp(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return getGcp(b, a % b);
    }
}
