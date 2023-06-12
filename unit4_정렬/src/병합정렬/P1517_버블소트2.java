package 병합정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1517_버블소트2 {
    public static long[] A,  tmp;
    public static long cnt;

    public static void out() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        A = new long[N+1];
        tmp = new long[N+1];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=1;i<A.length;i++){
            A[i] = Long.parseLong(st.nextToken());
        }

        cnt = 0; //초기화
        mergeSort(1, N);
        
        //정렬 후 출력
        System.out.println(cnt);
    }

    private static void mergeSort(int s, int e) {
        if(e-s < 1){ //최소 단위로 쪼갰을 경우 (1개) 분할 끝
            return;
        }

        int m = s + (e-s)/2;

        mergeSort(s, m);
        mergeSort(m+1, e);
        
        //conquer 전 사용할 tmp 배열 갖추기
        for(int i=s;i<=e;i++){
            tmp[i] = A[i];
        }

        int k = s; //합친 배열 전체 인덱스로 통용되는 변수
        int idx1 = s;
        int idx2 = m+1;

        //idx가 밖으로 빠져나오지 않게
        while(idx1 <= m && idx2 <= e){
            if(tmp[idx1] > tmp[idx2]){
                A[k] = tmp[idx2];
                cnt += (idx2 - k);
                k++;
                idx2++;
            }else{ //오른쪽으로 이동은 swap X
                A[k] = tmp[idx1];
                k++;
                idx1++;
            }
        }
        while(idx1<=m){
            A[k] = tmp[idx1];
            k++;
            idx1++;
        }
        while(idx2<=2){
            A[k] = tmp[idx2];
            k++;
            idx2++;
        }

    }
}
