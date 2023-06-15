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
                //자릿수 기준 해당하는 큐에 개수++ (일의 자리~천의 자리)
                bucket[(A[i]/digit)%10]++;
            }
            //합 배열 사용해 index 계산
            for(int i=1;i<10;i++){
                bucket[i] += bucket[i-1];
            }
            //output에 순서대로 재정렬
            for(int i = A.length-1; i>=0; i--){ //A의 요소들을 역순으로 탐색
                output[bucket[(A[i]/digit)%10]-1] = A[i]; //A[i]를 현재 자릿수에서 해당하는 bucket 배열의 개수에 맞는 인덱스에 저장
                bucket[(A[i]/digit)%10]--;//요소를 output에 하나 저장했으니 bucket에 있는 수 하나
            }
            //재정렬된 A로 다시 돌리기 
            for(int i=0;i<A.length;i++){
                A[i] = output[i];
            }
            //자릿수 늘리기
            digit = digit * 10;
            count++;
        }

    }
}
