package D2;

import java.util.Scanner;

public class P1940_가랏RC카 {
    static int cmd; //초 단위로 주어지는 명령어
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt(); //입력 횟수
            int v = 0; //초기 속도
            int distance = 0; //이동 거리

            sb.append("#").append(test_case).append(" ");
            while (N-- > 0) {
                cmd = sc.nextInt();
                if (cmd != 0) {
                    if (cmd == 1) { // 가속인 경우
                        v += sc.nextInt();
                    } else if (cmd == 2) {
                        v -= sc.nextInt();
                        if (v < 0)
                            v = 0;
                    }
                }
                distance += v;
            }
            sb.append(distance).append("\n");
        }
        System.out.println(sb);
    }
}
