package 약수_배수_소수;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class P9506_약수들의_합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> fL = new LinkedList<Integer>();
        Stack<Integer> fR = new Stack<Integer>();

        while (n != -1) {
            int sum = 0;
            //1. 약수 구하기
            fL.add(1);
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    fL.add(i);
                    if (i == Math.sqrt(n))
                        break;
                    fR.push(n / i);
                }
            }
            //2. 완전 수 판별
            StringBuilder sb = new StringBuilder();
            sb.append(n + " = ");
            //left 먼저 출력
            int f = 0;
            while (!fL.isEmpty()) {
                f = fL.poll();
                sum += f;
                sb.append(f + " + ");
            }
            //right 출력
            while (!fR.empty()) {
                f = fR.pop();
                sum += f;
                if (fR.empty()) {
                    sb.append(f);
                } else {
                    sb.append((f + " + "));
                }
            }
            //완전수 판별
            if(sum == n)
                System.out.println(sb);
            else
                System.out.println(n +" is NOT perfect.");
            //초기화
            fL.clear();
            fR.clear();
            //다음 수 받기
            n = sc.nextInt();
        }
    }
}
