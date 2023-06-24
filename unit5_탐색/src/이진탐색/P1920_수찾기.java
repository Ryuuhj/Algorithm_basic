package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class P1920_수찾기 {
    static int[] A;
    static int N, M;

    public static void out() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(bf.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        //오름차순 정렬 
        Arrays.sort(A);

        M = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        
        for(int i = 0; i<M; i++){
            int success = 0;
            int target = Integer.parseInt(st.nextToken());
            int start = 0; 
            int end = N-1;
            while(start <= end){
                int medIdx = (start + end)/2;
                System.out.println("midi>>>>" + medIdx);
                int median = A[medIdx];
                if(median == target){
                    success = 1;
                    break;
                } else if(median < target){
                    start = medIdx + 1;
                }else{ //median > target
                    end = medIdx - 1;
                }
            }
            sb.append(success+"\n");
        }
        System.out.println(sb);
    }
}
