package 소수_구하기;
import java.util.Scanner;

public class P1456_거의소수 {
    static long A, B;
    
    public static void out() {
        Scanner sc = new Scanner(System.in);
        final int max = 10000000;
        A = sc.nextLong();
        B = sc.nextLong();
        
        boolean[] isNotPrime = new boolean[max+1];
        

        isNotPrime[0]= isNotPrime[1] = true;
        for(int i=2; i <= Math.sqrt(max);i++){
            if(isNotPrime[i]) continue;
            for(int j=2*i; j <= max; j += i){ //i의 배수인 수들 소수 탈락
                isNotPrime[j] = true;
            }
        }
        
        
        long cnt = 0;

        for(long i=2; i<isNotPrime.length; i++){
            if(isNotPrime[(int)i]) continue; //소수 아닌 수 들은 패스

            long sq = i*i;
            while(sq <= B){
                
                if(A <= sq) cnt++;
                sq *= i;
                if(sq % i != 0) break; //i^3 이상부터 long 범위를 초과해 쓰레기 값이 담기면 sq<=B로 걸러지지 못하므로 break 해줌
            }
        }

        System.out.println(cnt);
        
    }
    
}
