package 병합정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2751_수_정렬하기2 {
    public static int[] A, tmp;

    public static void out() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        tmp = new int[N+1];

        for(int i=1;i<A.length;i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(1, N);
        //정렬 후 답(A) 옮겨 담기
        for(int j=1;j<A.length;j++){
            stringBuilder.append(A[j]+"\n");
        }
        String str = stringBuilder.toString();
        System.out.println(str);
    }

    private static void mergeSort(int s, int e) {
        //e <= s 인 경우
        if(e-s < 1) return;
        //파티션 나눌 중간값
        int m = s + (e-s)/2;
        //재귀함수 형태로 구현
        mergeSort(s, m); //group 1
        mergeSort(m+1, e); //group 2

        //정렬할 값 A -> tmp로 옮겨 담기 (tmp값을 이용해 다시 A에 정렬할 것)
        for(int i=s; i<=e; i++){
            tmp[i] = A[i];
        }

        int k = s;
        int index1 = s; //group1 피봇
        int index2 = m+1; //group2 피봇

        //group 1, 2 병합하는 로직
        while(index1 <= m && index2 <=e){
            //양쪽 그룹 index1, 2 가 가리키는 값 비교 -> 하나 빠지면 index++
            if(tmp[index1] < tmp[index2]){
                A[k] = tmp[index1];
                k++;
                index1++;
            }else{
                A[k] = tmp[index2];
                k++;
                index2++;
            }
        }

        //한 그룹이 끝난 후 남은 그룹에 있는거 몰아담기
        while(index1 <= m){
            A[k] = tmp[index1];
            k++;
            index1++;
        }
        while(index2 <= e){
            A[k] = tmp[index2];
            k++;
            index2++;
         }
    }
}
