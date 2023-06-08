package 삽입정렬;

import java.util.Arrays;
import java.util.Scanner;

public class P11399_ATM2 {
    public static void out(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] P = new int[N];
        
        for(int i=0; i<N;i++){
            P[i] = sc.nextInt();
        }

        Arrays.sort(P);

        int sum = 0;
        for(int j=0;j<N;j++){
            sum += (P[j]*(N-j));
        }
        System.out.println(sum);

    }
}
