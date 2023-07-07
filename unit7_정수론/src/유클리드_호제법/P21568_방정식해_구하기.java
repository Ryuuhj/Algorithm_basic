package 유클리드_호제법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P21568_방정식해_구하기 {
    static int a, b, c;
    public static void out() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        long gcdAB = gcd(a, b);
        int K;
        if((c % gcdAB) != 0){
            System.out.println(-1);
            return;
        }else{
            K = (int)(c/gcdAB);
            long[] xy = excute(a, b);
            stringBuilder.append(xy[0]*K+" "+xy[1]*K);
            
        }

        System.out.println(stringBuilder);
        
    }

    private static long[] excute(long a, long b) {
        long[] xy = new long[2];
        //확장 실행하다가 나머지 0까지 도달했을 때 (터닝 포인트)
        if(b==0){
            xy[0] = 1; //x 초기값 = 1
            xy[1] = 0; //y 초기값 = 1
            return xy; //초기값 담은 xy 리턴
        }
        //3번 과정 + 
        long quotient = a/b; //거슬러 올라가는 시작지점에서 나머지 0
        long priorXY[] = excute(b, a%b); 
        //b==0일 때까지 실행 후 priorXY[0],[1]에 각각 1, 0 이 저장될 것
        xy[0] = priorXY[1]; //x = y’
        xy[1] = priorXY[0]- (priorXY[1] * quotient); //y = x’ - y’*q
        return xy;
    }

    private static int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b, a%b);
    }
}
