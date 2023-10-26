package D3;

import java.util.Scanner;

public class P5607_조합 {
    static long[] factorial = new long[1000001];
    static final int K = 1234567891;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        factorial[0] = 1;
        for (int i = 1; i < 1000001; i++) { //N!
            factorial[i] = (factorial[i - 1] * i) % K;
        }
        for (int t = 0; t < T; t++) {
            sb.append("#").append(t+1).append(" ");
            int N = sc.nextInt();
            int R = sc.nextInt();

            sb.append(getComb(N, R)).append("\n");

        }
        System.out.println(sb);
    }

    private static long getComb(int N, int R) {
        long A = factorial[N];
        long B = (factorial[R] * factorial[N - R]) % K;
        //B^(K-2) 구하기
        long C = getPow(B, K - 2);
        return A * C % K;
    }
    private static long getPow(long a, int e) {
        if(e == 1)
            return a;

        long tmp = getPow(a, e / 2) % K;

        if(e % 2 == 0) //짝수인 경우
            return tmp * tmp % K;
        else
            return ((tmp * tmp) % K * a) % K;
    }
}
