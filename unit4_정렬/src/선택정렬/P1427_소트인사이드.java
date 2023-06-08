package 선택정렬;

import java.util.Scanner;


public class P1427_소트인사이드 {
    public static void out() {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] A = new int[str.length()];

        for(int i=0; i<A.length; i++){
            A[i] = Integer.parseInt(str.substring(i, i+1));
        }

        for(int i=0; i < A.length-1;i++){
            int max = i;
            for(int j=i+1; j<A.length;j++){
                if(A[max]<A[j]) max = j;
            }
            if(max != i){
                int temp = A[i];
                A[i] = A[max];
                A[max] = temp;
            }
        }
        for(int k : A){
            System.out.print(k);
        }
    }
}
