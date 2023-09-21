package 정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P18870_좌표압축_ver2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] origin = new int[N];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
        }
        int[] sorted = Arrays.copyOf(origin, N);
        Arrays.sort(sorted);

        int rank = 0;
        for (int s : sorted) {
            if (!map.containsKey(s)) {
                map.put(s, rank);
                rank++;
            }
        }
        for (int o : origin) {
            bw.write(map.get(o) + " ");
        }
        bw.close();



    }
}
