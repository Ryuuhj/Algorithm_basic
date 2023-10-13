package D2;

import java.util.Scanner;

public class P1204_최빈수_구하기 {
    static int[] freq;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(sc.nextInt()).append(" ");
            freq = new int[101];
            for (int i = 0; i < 1000; i++) {
                freq[sc.nextInt()] += 1;
            }

            int max = 0;
            int ans = 0;
            for (int i = 0; i <= 100; i++) {
                if (freq[i] >= max) { //최빈수가 여러개일땐 가장 큰 정수 출력
                    max = freq[i];
                    ans = i;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
