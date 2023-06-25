package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2343_기타레슨 {
    static int[] lectures;
    static int N, M;
    //static int minSize;
    public static void out() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lectures = new int[N];
        int start =0, end = 0;

        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<N; i++){
            lectures[i] = Integer.parseInt(st.nextToken());
            if(start < lectures[i]){
                start = lectures[i];
            }
            end += lectures[i];
        }

        int count=0, sum = 0;
        while(start <= end){
            int median = (start + end)/2;
            
            for(int j=0; j<N; j++){
                int length = lectures[j];
                if(sum + length <= median){
                    sum += length;
                }else{
                    sum = length;
                    count++;
                }
            }
            if(sum!=0) count++;
            if(count <= 3)
                end = median -1;
            else
                start = median +1;
        }
        System.out.println(start);
    }
}
