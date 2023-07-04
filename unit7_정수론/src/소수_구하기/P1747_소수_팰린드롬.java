import java.util.Scanner;

public class P1747_소수_팰린드롬 {
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
        String num = Integer.toString(n);
        int length = num.length();
        boolean flag;

        if(length%2==0) flag = false;
        else flag = true; //flag가 true-> odd, false-> even

        if(length==1) return true; //일의 자리는 무조건 pass
        
        int limit = flag ? length/2-1 : length/2;

        for(int i=0; i <= limit; i++){
            char c1 = num.charAt(i);
            char c2 = num.charAt((length-1)-i);
            
            if(c1 != c2)
                return false;
        }
        return true; //끝까지 잘 통과하면 true

    }
    
}
