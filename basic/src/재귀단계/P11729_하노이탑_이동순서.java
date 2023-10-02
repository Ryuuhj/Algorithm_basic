package 재귀단계;

import java.util.Scanner;

public class P11729_하노이탑_이동순서 {
    static int cnt = 0;
    static StringBuilder ans = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        doHanoi(N, 1, 2, 3);

        System.out.println(cnt);
        System.out.println(ans);

    }

    private static void doHanoi(int n, int start, int mid, int end) {
        if (n == 1) {
            ans.append(start).append(" ").append(end).append("\n");
            cnt++;
            return;
        }
        //1. n-1개 1 -> 2로 이동
        doHanoi(n - 1, start, end, mid);
        //2. 이동 끝나면 마지막 하나 1 -> 3 이동
        ans.append(start).append(" ").append(end).append("\n");
        cnt++;
        //3. 2에 있던 n-1개 마찬가지로 2 -> 3 이동 반복 시작
        doHanoi(n - 1, mid, start, end);
    }
}
