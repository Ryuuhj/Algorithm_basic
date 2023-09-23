package 집합과_맵;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P1764_듣보잡 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> hearM = new HashSet<String>();

        while (N-- > 0) {
            hearM.add(br.readLine());
        }
        String s;
        ArrayList<String> ans = new ArrayList<>();
        while (M-- > 0) {
            s = br.readLine();
            if (hearM.contains(s)) {
                ans.add(s);
            }
        }
        Collections.sort(ans);

        bw.write(ans.size() + "\n");
        for (String o : ans) {
            bw.write(o + "\n");
        }
        bw.close();
    }
}
