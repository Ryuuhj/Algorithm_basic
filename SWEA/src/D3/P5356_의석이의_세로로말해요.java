package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P5356_의석이의_세로로말해요 {
    static char[][] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");
            input = new char[5][15];
            int max = 0;
            for (int i = 0; i < 5; i++) {
                char[] word = br.readLine().toCharArray();
                for (int j = 0; j < word.length; j++) {
                    input[i][j] = word[j];
                }
                max = Math.max(max, word.length);
            }
            for (int v = 0; v < max; v++) {
                for (int h = 0; h < 5; h++) {
                    if (input[h][v] != '\0')
                        sb.append(input[h][v]);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
