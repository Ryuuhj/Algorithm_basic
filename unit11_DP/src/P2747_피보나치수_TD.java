import java.util.Arrays;
import java.util.Scanner;

public class P2747_피보나치수_TD {
    static int[] D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        D = new int[n + 1];
        //배열 초기화
        Arrays.fill(D, -1);
        //초기값 설정 D[0] = 0, D[1] = 1
        D[0] = 0;
        D[1] = 1;
        //피보나치 점화식 -> DP 테이블 완성
        fibo(n);
        System.out.println(D[n]);
    }

    private static int fibo(int n) {
        if (D[n] != -1) {
            return D[n];
        }
        //재귀함수 형태를 사용하되, 구한 값을 바로 리턴하지 않고 저장한 뒤 리턴
        return D[n] = fibo(n - 1) + fibo(n - 2);
    }
}
