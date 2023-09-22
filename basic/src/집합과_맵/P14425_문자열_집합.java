package 집합과_맵;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P14425_문자열_집합 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> stringSet = new HashSet<String>();

        while (N-- > 0) {
            stringSet.add(bf.readLine());
        }

        int cnt = 0;
        while (M-- > 0) {
            if(stringSet.contains(bf.readLine())) cnt++;
        }

        System.out.println(cnt);
    }
}
