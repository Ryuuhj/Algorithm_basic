package 그래프의_표현;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2251_물통 {
    // A->B, A->C, B->A, B->C, C->A, C->B
    // A = 0, B = 1, C = 2
    static int[] pouring = { 0, 0, 1, 1, 2, 2 };
    static int[] poured = { 1, 2, 0, 2, 0, 1 };
    static boolean visited[][]; // 특정 edge에 대해 중복여부 검사해야 하므로 2차원
    static boolean answer[];
    static int capacity[]; // 현재 용량

    public static void out() {
        Scanner sc = new Scanner(System.in);
        // A, B, C 용량 저장
        capacity = new int[3];
        capacity[0] = sc.nextInt();
        capacity[1] = sc.nextInt();
        capacity[2] = sc.nextInt();
        // 방문 배열, answer 배열 초기화
        visited = new boolean[201][201]; // A,B는 200이하 자연수[A][B]
        answer = new boolean[201];
        BFS();
        // 완전 탐색이 끝난 후 정답배열에서 값이 true인 idx만 저장해 출력
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < answer.length; i++) {
            if (answer[i])
                st.append(i + " ");
        }
        System.out.print(st);
    }

    private static void BFS() {
        Queue<AB> queue = new LinkedList<>(); // 인접 노드 담을 큐
        queue.add(new AB(0, 0)); // 처음에 0, 0, 10으로 시작
        visited[0][0] = true;
        answer[capacity[2]] = true; // 1. C용량 1인 경우
        while (!queue.isEmpty()) {
            AB now = queue.poll(); // 노드 하나 꺼내기
            // 현재 A, B, C 용량
            int A = now.A;
            int B = now.B;
            int C = capacity[2] - (A + B);
            // 가능한 경우의 수 실행
            for (int i = 0; i < pouring.length; i++) {
                int[] next = { A, B, C }; // 기존 용량
                int pouringNum = pouring[i];
                int pouredNum = poured[i];
                // 받는 물통 += 붓는 물통
                next[pouredNum] += next[pouringNum];
                next[pouringNum] = 0;
                if (next[pouredNum] > capacity[pouredNum]) {// 용량 초과
                    next[pouringNum] = next[pouredNum] - capacity[pouredNum]; // 초과량 시작점으로 다시 빽
                    next[pouredNum] = capacity[pouredNum];
                }
                // 부어서 만든 결과가 앞선 사례와 중복되지 않는 경우
                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    queue.add(new AB(next[0], next[1])); // 해당 경우 큐에 삽입
                    // 기존과 중복되지 않는 경우의 수 이면서 A의 상태가 0인 경우, C용량 답에 추가
                    if (next[0] == 0) {
                        answer[next[2]] = true;
                    }
                }
            }
        }
    }
}

class AB {
    int A;
    int B;

    public AB(int a, int b) {
        this.A = a;
        this.B = b;
    }
}
