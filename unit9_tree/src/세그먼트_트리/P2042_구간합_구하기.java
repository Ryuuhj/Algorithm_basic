package 세그먼트_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2042_구간합_구하기 {
    static int n, m, k;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int depth = 0, length = n;
        while (length != 0) {
            length /= 2;
            depth++;
        }
        int treeSize = (int) Math.pow(2, depth + 1); // 2^(k+1)
        int rsIdx = treeSize / 2 - 1; //remain_start_index
        tree = new long[treeSize];
        //리프 노드 입력 받기
        for (int i = rsIdx + 1; i <= rsIdx + n; i++) {
            tree[i] = Long.parseLong(bf.readLine());
        }
        //나머지 거슬러 올라가며 채우기
        setRemainTree(treeSize - 1);
        //변경 횟수 + 구간합 만큼 트리 값 조정 & 값 도출
        int count = m + k;
        StringBuilder ans = new StringBuilder();
        while (count -- > 0) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if (a == 1) {
                update(b + (treeSize / 2 - 1), c);
            } else if (a == 2) {
                ans.append(getSegSum(b + (treeSize / 2 - 1), (int)c + (treeSize / 2 - 1))+"\n");
            }

        }
        System.out.println(ans);
    }

    private static long getSegSum(int start, int end) {
        long segmentSum = 0;
        while (start <= end) {
            if (start % 2 == 1)
                segmentSum += tree[start];
            if (end % 2 == 0)
                segmentSum += tree[end];
            start = (start + 1) / 2;
            end = (end - 1) / 2;
        }
        return segmentSum;
    }

    private static void update(int idx, Long newValue) {
        long diff = newValue - tree[idx];
        tree[idx] = newValue;
        while (idx != 1) {
            idx /= 2;
            tree[idx] += diff;
        }
    }

    private static void setRemainTree(int end) {
        while (end != 1) {
            tree[end / 2] += tree[end];
            end--;
        }
    }
}
