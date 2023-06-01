package 투_포인터;

import java.util.Scanner;

public class P2018_수들의합5{
    static Scanner sc;
    static long N;
    public void out(){
        sc = new Scanner(System.in);
        long sum = 1;
        long count = 1;
        long startIdx = 1;
        long endIdx = 1;
        N = sc.nextInt();

        while(endIdx != N){
            if(sum < N){ endIdx++; sum += endIdx; }
            else if(sum > N){ sum -= startIdx; startIdx++; }
            else if(sum == N){ endIdx++; sum += endIdx; count++;}
        }
        System.out.println(count);
    }
}