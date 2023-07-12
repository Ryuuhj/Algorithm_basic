package 유니온_파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1043_거짓말 {
    static int[] parent;
    static int N, M;

    public static void out() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        Arrays.setAll(parent, idx -> idx);

        st = new StringTokenizer(bf.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int i=0; i<T; i++){
            int idx = Integer.parseInt(st.nextToken());
            parent[idx] = 0;
        }

        int[][] party = new int[M][N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(bf.readLine());
            party[i][0] = Integer.parseInt(st.nextToken()); //참가 인원 수
            for(int j = 1; j<=party[i][0]; j++){
                party[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //파티 참여 시 하나의 집합으로 union
        for(int i=0; i<M; i++){
            int pNum = party[i][0];
            if(pNum <= 1) continue;

            int firstP = party[i][1];
            for(int j=2; j<=pNum; j++){
                union(firstP, party[i][j]);
            }
        }
        //과장 가능한 파티 수 카운트 및 출력
        int cnt = 0;
        for(int i=0; i<M; i++){
            int root = find(party[i][1]);
            if(root != 0) cnt++; //진실 아는 사람 없는 경우 cnt
        }
        System.out.println(cnt);
        
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        parent[rootA <= rootB ? rootB : rootA] = (rootA <= rootB ? rootA : rootB);
    }

    private static int find(int x) {
        if(parent[x] == x) return x;
        else{
            parent[x] = find(parent[x]);
            return parent[x];
        }  
    }
   
}
