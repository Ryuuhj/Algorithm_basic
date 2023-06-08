package 삽입정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11399_ATM {
    public static void out() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] P = new int[N];
        int[] S = new int[N];
        st = new StringTokenizer(bf.readLine());

        for(int i=0;i<N;i++){
            P[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<N;i++){
            int insertPoint = i;
            int insertValue = P[i]; 
            for(int j=i-1; j>=0 ; j--){
                if(P[j]<P[i]) {
                    insertPoint = j+1;
                    break;
                }
                if(j == 0) insertPoint = 0; //제일 작은 값-> 맨 앞에 삽입
            }
            for(int j=i; j> insertPoint; j--){ //i_p ~ i-1까지 한 칸씩 미룸 
                P[j] = P[j-1];
            }
            P[insertPoint] = insertValue;
        }

        S[0]=P[0];
        for(int i=1;i<N;i++){
            S[i] = S[i-1] + P[i];
        }
        
        int sum = 0;
        for(int n : S){
            sum += n;
        }
        System.out.println(sum);

    }
}
