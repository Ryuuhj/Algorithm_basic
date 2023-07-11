package 유니온_파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1976_여행가자 {
    static int[] parent;
    
    public static void out() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        parent = new int[N+1];
        int[] route = new int[M];
        int[][] adjArray = new int[N+1][N+1];
        StringTokenizer st;

        //parent 초기화
        Arrays.setAll(parent, idx -> idx);

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=1; j<=N; j++){
                adjArray[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        //마지막 경로
        st = new StringTokenizer(bf.readLine());
        for(int k=0; k<M; k++){
            route[k] = Integer.parseInt(st.nextToken());
        }
        //루트 중 중복 제거
        int[] routeSet = Arrays.stream(route).distinct().toArray();
        //Arrays.stream(routeSet).forEach(num->System.out.println(num));

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(adjArray[i][j] == 1) union(i, j);
            }
        }
        //Arrays.stream(parent).forEach(num->System.out.println(num));


        int rootNum = parent[routeSet[0]];
        for(int idx : routeSet){
            if(parent[idx] != rootNum) {
                System.out.println("NO");
                return; //종료
            }
        }
        System.out.println("YES");

    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if(rootA == rootB) return;
        if(rootA <= rootB)
            parent[rootB] = rootA;
        else
            parent[rootA] = rootB;
    }

    private static int find(int x) {
        if(x == parent[x]) return x;
        else{
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
}
