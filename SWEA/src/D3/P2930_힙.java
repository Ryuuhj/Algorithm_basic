package D3;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P2930_힙 {
    static PriorityQueue<Integer> pq;
    static int N, cmd, x;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 >= o2 ? -1 : 1;
            }
        };
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            N = sc.nextInt();
            pq = new PriorityQueue<Integer>(comparator);
            while (N-- > 0) {
                cmd = sc.nextInt();
                if (cmd == 1) {
                    x = sc.nextInt();
                    pq.add(x);
                } else {
                    if (pq.isEmpty()) {
                        sb.append("-1 ");
                        continue;
                    }
                    sb.append(pq.poll()).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
