package 유니온_파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1717_집합의표현 {
    static int[] parent;

    public static void out() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder answer = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        Arrays.setAll(parent, idx -> idx); //인덱스 값으로 초기화
        //질의 수행
        for(int i=0; i<M; i++){
            st = new StringTokenizer(bf.readLine());
            int k = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if(k == 0) union(a, b);
            else {
                boolean result = equals(a, b);
                if(result) answer.append("YES\n");
                else answer.append("NO\n");
            }
        }
        System.out.print(answer);
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if(rootA == rootB) return;
        parent[rootA<rootB ? rootB : rootA] = (rootA<rootB ? rootA : rootB);
    }

    private static int find(int x) {
        if(x == parent[x])
            return x;
        else{
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }

    private static boolean equals(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if(rootA == rootB) return true;
        else return false;
    }
}
