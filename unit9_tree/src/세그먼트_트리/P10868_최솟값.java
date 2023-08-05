package 세그먼트_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class P10868_최솟값 {
    static int[] tree;
    static int step;
    static int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int depth = 0, length = n;
        while (length != 0) {
            depth++;
            length /= 2;
        }
        int treeSize = (int) Math.pow(2, depth + 1);
        step = treeSize / 2;
        tree = new int[treeSize];
        Arrays.fill(tree, MAX);

        for (int i = step; i < step + n; i++) {
            tree[i] = Integer.parseInt(bf.readLine());
        }
        //나머지 업데이트
        setRemainTree(step - 1);
        StringBuilder ans = new StringBuilder();
        while (m-- > 0) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ans.append(getMin(a, b) + "\n");
        }
        System.out.println(ans);

    }

    private static int getMin(int start, int end) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        start += (step - 1);
        end += (step - 1);
        while (start <= end) {
            if(start%2 == 1)
                queue.add(tree[start]);
            if (end % 2 == 0)
                queue.add(tree[end]);
            start = (start + 1) / 2;
            end = (end - 1) / 2;
        }
        return queue.poll();
    }

    private static void setRemainTree(int end) {
        for (int i = end; i >0; i--) {
            tree[i] = Math.min(tree[2 * i], tree[2 * i + 1]);
        }
    }
}
