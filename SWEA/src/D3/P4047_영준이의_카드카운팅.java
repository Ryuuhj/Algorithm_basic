package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P4047_영준이의_카드카운팅 {
    static int[] cardCnt;
    static boolean[][] having;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        loopT:
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");
            cardCnt = new int[4];
            Arrays.fill(cardCnt, 13);
            having = new boolean[4][13];
            String str = br.readLine();
            for (int i = 0; i < str.length(); i+= 3) {
                int idx = parseIdx(str.charAt(i));
                int num = Integer.parseInt(str.substring(i + 1, i + 3));
                if (having[idx][num]) {
                    sb.append("ERROR\n");
                    continue loopT;
                }
                cardCnt[idx]--;
                having[idx][num] = true;
            }
            for (int i = 0; i < cardCnt.length; i++) {
                sb.append(cardCnt[i] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int parseIdx(char c) {
        switch (c) {
            case 'S':
                return 0;
            case 'D':
                return 1;
            case 'H':
                return 2;
            case 'C':
                return 3;
        }
        return -1;
    }
}
