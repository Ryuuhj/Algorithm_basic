package 소수_구하기;
import java.util.Scanner;

public class P1016_제곱ㄴㄴ수 {
    public static void out(){
        Scanner sc = new Scanner( System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();
        boolean[] square = new boolean[(int)(max-min+1)];
        int cnt = 0;

        for(long i = 2; i <= Math.sqrt(max); i++){
            long sn = i*i;
            long start_idx = min/sn;
            if(min%sn != 0){
                start_idx++;
            }
            for(long j = start_idx; j<=max/sn;j++){
             square[(int)((j * sn) - min)] = true; //제곱수의 배수를 true로
            }
        }
        
        for(boolean tf : square){
            if(!tf) cnt++;
        }
        System.out.println(cnt);

    }
}
