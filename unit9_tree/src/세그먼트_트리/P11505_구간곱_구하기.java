package 세그먼트_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11505_구간곱_구하기 {
    static long[] tree;
    static int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int depth = 0, length = n;
        while (length != 0) {
            length /= 2;
            depth++;
        }
        int treeSize = (int) Math.pow(2, depth + 1);
        int step = treeSize / 2;

        tree = new long[treeSize];
        Arrays.fill(tree, 1);
        for (int i = step; i < step + n; i++) {
            tree[i] = Long.parseLong(bf.readLine());
        }
        //나머지 채우기
        setRemainTree(treeSize - 1);
        //m+k 만큼 질의 실행
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if (a == 1) {
                updateTree(b + step - 1, c);
            } else if (a == 2) {
                sb.append(getProduct(b + step - 1, (int) c + step - 1) + "\n");
            }
        }
        System.out.println(sb);
    }

    private static long getProduct(int start, int end) {
        long result = 1;
        while (start <= end) {
            if (start % 2 == 1) {
                result = result * tree[start] % MOD;
            }
            if (end % 2 == 0) {
                result = result * tree[end] % MOD;
            }
            start = (start + 1) / 2;
            end = (end - 1) / 2;
        }
        return result;
    }

    private static void updateTree(int idx, long value) {
        tree[idx] = value;
        while (idx > 1) {
            idx /= 2;
            tree[idx] = tree[idx * 2] % MOD * tree[idx * 2 + 1] % MOD;
        }
    }

    private static void setRemainTree(int i) {
        while (i-- > 2) {
            tree[i / 2] = tree[i / 2] * tree[i] % MOD;
        }
    }
}
