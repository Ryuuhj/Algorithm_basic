package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1300_K번째수 {
    static int N, K;
    public static void out()throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        K = Integer.parseInt(bf.readLine());
        int start = 1;
        int end = K;
        while(start < end){
            int middle = (start+end)/2;
            int count = 0;
            for(int i=1; i<=N; i++){
                count += Math.min(middle/i, N);
            }
            if(count < K) start = middle+1;
            else end = middle;
        }
        System.out.println(start);
    }
}
