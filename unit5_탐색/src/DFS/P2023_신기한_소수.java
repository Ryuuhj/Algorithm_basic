package DFS;

import java.util.Scanner;
import java.math.*;

public class P2023_신기한_소수 {
    static int N;
    static int primeNum[] = {2, 3, 5, 7};
    static int oddNum[] = {1, 3, 5, 7, 9};

    public static void out(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int k : primeNum){
            dfs(k, 1);
        }
    }

    private static void dfs(int k, int digit) {
        if(digit == N){
            if(isPrime(k)==1){
                System.out.println(k);
            }
            return;
        }
        for(int o : oddNum){
            int result = k*10 + o;
            if(isPrime(result)==1){
                dfs(result, digit+1);
            }
        }
        return;
    }

    private static int isPrime(int k) {
        for(int i=2; i<= Math.sqrt(k);i++){
            if((k%i)==0) return 0; //약수가 있는 경우 -> 0 반환 후 종료
        }
        return 1; //소수일 경우 1
    }
}
