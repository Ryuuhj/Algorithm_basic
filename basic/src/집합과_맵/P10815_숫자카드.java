package 집합과_맵;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P10815_숫자카드 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        HashSet<String> card = new HashSet<String>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (N-- > 0) {
            card.add(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (M-- > 0) {
            if (card.contains(st.nextToken()))
                bw.write(1 + " ");
            else
                bw.write(0 + " ");
        }
        bw.close();

    }
}
