package 투_포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1253_좋은수 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    public static void out() throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());

        long[] A = new long[N];
        int cnt = 0;

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i<N; i++){
            A[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(A);

        
        for(int k = 0; k<N; k++){
            long G = A[k];
            int i = 0;
            int j = N-1;
            long sum;
            while(i<j){
                sum = A[i]+A[j];
                if(sum == G){
                    if((k!=i)&&(k!=j)){cnt++; break;}
                    else{i++; j--;}
                }
                else if(sum > G) j--;
                else i++;
            }
        }
        System.out.println(cnt);
    }
}
