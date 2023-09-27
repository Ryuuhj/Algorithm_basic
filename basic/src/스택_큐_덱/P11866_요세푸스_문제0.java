package 스택_큐_덱;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class P11866_요세푸스_문제0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int K = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        IntStream.range(1, N + 1).forEach(queue::offer);

        int cnt = 1, tmp = 0;
        sb.append("<");
        while (!queue.isEmpty()) {
            if (cnt % K == 0) {
                sb.append(queue.poll()).append(", ");
            } else {
                tmp = queue.poll();
                queue.offer(tmp);
            }
            cnt++;
        }
        sb.setLength(sb.length() - 2); //마지막 2개 (, ) 제거
        sb.append(">");
        System.out.println(sb.toString());
    }
}
