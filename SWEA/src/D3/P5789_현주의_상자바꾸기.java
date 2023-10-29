package D3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P5789_현주의_상자바꾸기 {
    static int[][] range;
    static int[] boxes;
    static Set<Integer> set = new HashSet<>();
    static int N, Q;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            Q = sc.nextInt();
            range = new int[Q+1][2];
            boxes = new int[N+1];
            for (int i = 1; i <= N; i++) {
                set.add(i);
            }
            for (int i = 1; i <= Q; i++) {
                range[i][0] = sc.nextInt();
                range[i][1] = sc.nextInt();
            }
            for (int i = Q; i > 0 ; i--) {
                for (int j = range[i][0]; j <= range[i][1]; j++) {
                    if (set.contains(j)) {
                        boxes[j] = i;
                        set.remove(j);
                    }
                }
                if(set.isEmpty()) break;
            }
            sb.append("#").append(t).append(" ");
            for (int i = 1; i <= N; i++) {
                sb.append(boxes[i]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
