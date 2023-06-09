package 퀵정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11004_K번째수 {
    public static void out() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        st = new StringTokenizer(bf.readLine());
        
        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(A, 0, N-1, K-1);
        System.out.println(A[K-1]);
    }

    private static void quickSort(int[] A, int s, int e, int K) {
        if(s < e){
            int pivot = partition(A, s, e);
            if(pivot == K) return;
            else if(pivot < K) 
                quickSort(A, pivot+1, e, K);
            else 
                quickSort(A, s, pivot-1, K);
        }
    }

    //pivot을 선정하며 divide 하는 함수 (pivot 최종 위치 반환)
    private static int partition(int[] A, int s, int e) {
        if(s+1 == e){
            if(A[s] > A[e])swap(A, s, e); 
            return e;
        }
        int m = (s+e)/2; //중간 인덱스 구하기
        swap(A, s, m); //맨 앞이랑 값 교환

        int pivot_value = A[s]; //피봇값 맨 앞으로(피봇이 맨 앞으로 갔으니)

        int i = s+1, j = e;

        while(i<=j){
            //j 먼저 이동 (작은 값 나올 때 까지) && 끝 도달 방지 pivot은 제외한 배열이니 
            while((pivot_value < A[j]) && j>s){
                j--;
            }
            while((pivot_value > A[i]) && i < A.length-1){
                i++;
            }
            if(i<=j){ //멀리서 둘 다 멈춘 경우, 값 swap 후 한 칸씩 이동
                swap(A, i++, j--);
            }
        } 
        //i==j인 경우, 피벗의 값을 양쪽으로 분리한 가운데에 오도록 설정
        A[s] = A[j];
        A[j] = pivot_value;
        return j;
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    } 
}
