import java.util.Arrays;
import java.util.Scanner;

public class P1929_소수구하기 {
    static int N, M;
    
    public static void out() {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        M = sc.nextInt();
        N = sc.nextInt();
        

        boolean[] arr = new boolean[N+1];
        Arrays.fill(arr, true); //true로 초기화
        arr[1]=false;
        
        for(int i = 2; i<=Math.sqrt(N); i++){ //N의 제곱근 까지 진행
            if(!arr[i]) continue; //data 값이 false면 건너뛰기
            for(int j=i+1; j<arr.length; j++){
                if(j%i==0){ //약수인 경우
                    arr[j] = false;
                }
            }
        }
        //2도 소수가 아님...
        arr[2] = false;

        for(int i=M; i<arr.length; i++){
            if(arr[i]) sb.append(i+"\n");
        }
        System.out.println(sb);

    }
}
