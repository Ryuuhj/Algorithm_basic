package 소수_구하기;
import java.util.Scanner;

public class P1747_소수_팰린드롬ver2{
    static int N;
    static final int max = 10000000;

    public static void out(){
        Scanner sc = new Scanner(System.in);
        boolean[] isNotPrime = new boolean[max+1];

        N = sc.nextInt();

        isNotPrime[0] = isNotPrime[1] = true;
        for(int i=2; i<= Math.sqrt(max); i++){
            if(isNotPrime[i]) continue;
            for(int j=i*2; j<isNotPrime.length; j+=i){
                isNotPrime[j] = true;
            }
        }

        for(int i=N; i<isNotPrime.length; i++){
            if(isNotPrime[i]) continue;
            if(isPalindrome(i)){
                System.out.println(i);
                return;
            }
        }

    }

    private static boolean isPalindrome(int n) {
        //char[](문자 배열)을 사용해 사용
        char[] target = String.valueOf(n).toCharArray();
        int start = 0;
        int end = target.length-1;
        while(start < end){  //조건 start<end로 주면 아주 간단해진다...!...ㅎㅎ....
            if(target[start] != target[end]) return false;
            start++;
            end--;
        }
        
        return true;

    }
    
}
