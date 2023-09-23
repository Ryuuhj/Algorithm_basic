package 집합과_맵;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P1269_대칭_차집합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        HashSet<String> sdSet = new HashSet<>();

        String[] setA = br.readLine().split(" ");
        String[] setB = br.readLine().split(" ");

        for (String s : setA) {
            sdSet.add(s);
        }
        for (String s : setB) {
            if (sdSet.contains(s))
                sdSet.remove(s);
            else
                sdSet.add(s);
        }
        System.out.println(sdSet.size());
    }
}
