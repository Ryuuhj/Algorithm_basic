package 오일러_피;

import java.util.Scanner;

public class P11698_오일러피_구현 {
    public static void out(){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long result = n;

        for(long k=2; k<= Math.sqrt(n); k++){
            //k가 n의 소인수인 경우에만 관련 개수 result에서 깎기
            if(n % k == 0){
                result -= result/k;
                while(n % k == 0){ //n의 소인수 중 k 없을 때 까지 반복
                    n = n/k; //n을 구성하는 소인수에서 k제거(끝났으니)
                }
            }
        }

        //for문이 끝나고도 마지막 소인수가 남아있는 경우 result 값 걷어내기
        if(n>1) result -= result/n;

        System.out.println(result);
    }
}
