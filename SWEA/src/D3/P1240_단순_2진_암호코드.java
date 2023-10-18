package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P1240_단순_2진_암호코드 {
    static StringTokenizer st;
    static int N, M;
    static int answer;
    static final Map<String, Integer> map = new HashMap<String, Integer>(){{
        put("0001101", 0);
        put("0011001", 1);
        put("0010011", 2);
        put("0111101", 3);
        put("0100011", 4);
        put("0110001", 5);
        put("0101111", 6);
        put("0111011", 7);
        put("0110111", 8);
        put("0001011", 9);
        }
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            answer = 0;
            while (N-- > 0) {
                String tmp = br.readLine();
                if(answer != 0)
                    continue;
                int lastIdx = tmp.lastIndexOf("1");
                if (lastIdx > 0) {
                    String code = tmp.substring(lastIdx-55, lastIdx+1);
                    //System.out.println(code.length());
                    answer = isCorrect(code);
                }
            }
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static int isCorrect(String s) {
        int[] numsCode = new int[8];
        int odd = 0, even = 0;
        for (int i = 0; i < s.length(); i+= 7) {
            String tmp = s.substring(i, i + 7);
            numsCode[i / 7] = map.get(tmp);

        }
        for (int i = 0; i < numsCode.length; i++) {
            //0-> 홀수, 1-> 짝수 처리
            if (i % 2 == 0) {
                odd += numsCode[i];
            }else
                even += numsCode[i];
        }
        if ((odd * 3 + even) % 10 == 0) {
            return Arrays.stream(numsCode).sum();
        }else
            return 0;
    }
}
