package 플로이드_워셜;

import java.io.*;
import java.util.*;

public class P11404_플로이드 {
    static int n, m;
    final static int INF = 10000001;
    
    public static void out() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        m = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        int[][] cost = new int[n+1][n+1];
        for(int i=1; i<cost.length; i++){
            for(int j=1; j<=n; j++){
                if(i==j) 
                    cost[i][j] = 0;
                else 
                    cost[i][j] = INF;
            }
        }
        
        while(m-->0) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(cost[a][b] > c) cost[a][b] = c;
        }
        
        for (int k = 1; k <= n; k++) {
            for (int s = 1; s <= n; s++) {
                for (int e = 1; e <= n; e++) {
                    if(cost[s][e] > cost[s][k]+cost[k][e])
                        cost[s][e] = cost[s][k] + cost[k][e];
                }  
            }
        }
        
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i < cost.length; i++) {
            for (int j = 1; j < cost[i].length; j++) {
                if(cost[i][j] == INF) ans.append("0 ");
                else ans.append(cost[i][j]+" ");
            }
            ans.append("\n");
        }         
        System.out.println(ans);
    }
}
