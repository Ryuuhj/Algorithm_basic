import java.util.Scanner;

public class P11047_동전0 {
    static int N, K;
    static int[] A;

    public static void out() {
        Scanner sc = new Scanner(System.in);
        int cnt =0;
        N = sc.nextInt();
        K = sc.nextInt();

        A = new int[N];
        for(int i=0; i<A.length;i++){
            A[i] = sc.nextInt();
        }

        for(int i=N-1;i>=0;i--){
           if(A[i]<= K){
            cnt += K/A[i];
            K = K % A[i];
           } 
           if(K==0) break;
        }

        System.out.println(cnt);
        
    }
    
}