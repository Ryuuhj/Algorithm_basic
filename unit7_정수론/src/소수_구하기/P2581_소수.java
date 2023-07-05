package 소수_구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2581_소수 {
    static int N, M;
    static boolean isNotPrime[];

    public static void out() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(bf.readLine());
        N = Integer.parseInt(bf.readLine());
        isNotPrime = new boolean[N+1];

        isNotPrime[0]=isNotPrime[1]=true;

        for(int i=2; i <= Math.sqrt(N); i++){
            if(isNotPrime[i]) continue;
            for(int k=2*i; k<isNotPrime.length; k+=i){
                isNotPrime[k] = true;
            }
        }

        int Psum = 0;
        int minPrime = 0;
        boolean flag = true;

        for(int i= M; i<=N; i++){
            if(isNotPrime[i]) continue;
            if(flag){
                minPrime = i;
                flag = false;
            }
            Psum += i;
        }

        if(Psum == 0){
            System.out.println(-1);
            return;
        }
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append(Psum +"\n"+minPrime);
        System.out.print(sBuilder);
    }
}
