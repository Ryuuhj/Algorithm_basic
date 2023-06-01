package 투_포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1940_주몽 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static long M;
    public static void out() throws IOException{
        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int sum;
        int count = 0;

        st = new StringTokenizer(bf.readLine());
        for(int i=0 ;i<N ;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        //오름차순 정렬 
        Arrays.sort(A);
        //양 끝 인덱스 시작
        int s = 0;
        int e = N-1;
        //비교
        while(s < e){
            sum = A[s]+A[e];
            if(sum > M){ e--; }
            else if(sum < M){ s++; }
            else{ count++; s++; e--;}
        }
        System.out.println(count);
    }
}
