package 기수정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P10989_수정렬하기3 {
    public static int A[];
    public static long result;
    public static void out() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        for(int i=0; i<N; i++){
            A[i]=Integer.parseInt(br.readLine());
        }
        br.close();
        radixSort(A, 5);
        for(int n : A){
            bw.write(n+"\n");
        }
        bw.flush();
        bw.close();
    }
    
    private static void radixSort(int[] A, int maxSize) {
        //정렬 값 임시 보관할 배열
        int[] output = new int[A.length];
        int digit = 1; //기본 자릿수 구하기 위한 나누기 도구 (1,10,100,1000 ... )
        int count = 0; //자리수 (1, 2(10), 3(100) ... 개수 ver)
        while(count != maxSize){ //최대 자리수 넘지 않는 선에서,,,
            //자릿수 기준 순서대로 개수만 저장할 큐 정의
            int[] bucket = new int[10];
            
            for(int i=0; i<A.length; i++){
                //자릿수 기준 큐 저장 (일의 자리~천의 자리)
                
                bucket[(A[i]/digit)*digit]++;
            }
        }

    }
}
