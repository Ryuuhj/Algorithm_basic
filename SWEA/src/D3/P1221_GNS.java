package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1221_GNS {
    static String[] line;
    static int length;
    static StringTokenizer st;
    static String[] number = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();

        for (int t = 1; t <= T ; t++) {
            line = br.readLine().split(" ");
            length = Integer.parseInt(line[1]);
            int[] cnt = new int[10];
            StringTokenizer st = new StringTokenizer(br.readLine());
            //카운팅 정렬
            for (int i = 0; i < length; i++) {
                cnt[getIdx(st.nextToken())]++;
            }
            //정렬 후 출력
            ans.append("#").append(t).append("\n");
            for (int i = 0; i < 10; i++) {
                while (cnt[i] != 0) {
                    ans.append(number[i] + " ");
                    cnt[i]--;
                }
            }
            ans.append("\n");
        }
        System.out.println(ans);

    }

    private static int getIdx(String s) {
        for (int i = 0; i < 10; i++) {
            if (number[i].equals(s)) {
                return i;
            }
        }
        return 0;
    }
}
