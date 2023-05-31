package 구간_합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P11659_구간합 {
    public void out(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] nums = new int[N];
        int[] S = new int[N];
        for(int k = 0; k < N; k++){
            nums[k] = sc.nextInt();
            if(k == 0){ S[k] = nums[k]; }
            else{ S[k] = S[k-1] + nums[k]; }
            //System.out.println(S[i]);
        }
        for(int m = 0; m < M; m++){
            int i = sc.nextInt();
            int j = sc.nextInt();
            if(i<=1) System.out.println(S[j-1]);
            else System.out.println(S[j-1]-S[i-2]);
        }
    }
    
    public static void out2() throws IOException{
        //Scanner 대신 BufferedReader 사용
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //한 줄 씩 읽어서 space 간격으로 쪼갠 string 형태로 토큰화
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        //1번째 줄 : N,M 저장 - 형변환 필수
        int suNo = Integer.parseInt(stringTokenizer.nextToken());
        int quizNo = Integer.parseInt(stringTokenizer.nextToken());
        //누적합 갱신할 배열 생성
        long[] S = new long[suNo+1]; //S[idx+1]로 처음부터 만드려고
        //3번째 줄 : 숫자 배열은 저장할 필요가 없음!!! + 누적합 갱신 
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 1; i <= suNo; i++){
            S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());
            //S[0]은 값 따로 할당 없으면 0으로 채워진 상태
        }
        for(int q = 0; q < quizNo; q++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(S[j] - S[i-1]);
        }

    }
}