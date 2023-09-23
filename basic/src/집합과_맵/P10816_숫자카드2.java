package 집합과_맵;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P10816_숫자카드2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> card = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = 0;
        while (N-- > 0) {
            k = Integer.parseInt(st.nextToken());
            if (!card.containsKey(k)) {
                card.put(k, 1);
            } else {
                card.put(k, card.get(k) + 1);
            }
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (M-- > 0) {
            k = Integer.parseInt(st.nextToken());
            if (card.containsKey(k)) {
                bw.write(card.get(k) + " ");
            } else {
                bw.write("0 ");
            }
        }
        bw.close();
    }
}
