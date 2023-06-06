package 버블정렬;

import java.util.Scanner;

public class P2750_수_정렬하기{
    public static void out(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] A = new int[N];

        for(int i=0; i<A.length; i++){
            A[i] = sc.nextInt();
        }
        
        for(int i=0; i < N-1;i++){
            for(int j=0; j<N-i-1; j++){
                if(A[j]>A[j+1]){
                    int temp = A[j+1];
                    A[j+1] = A[j];
                    A[j] = temp;
                }
            }
        }

        for(int e:A){
            System.out.println(e);
        }
    }
}