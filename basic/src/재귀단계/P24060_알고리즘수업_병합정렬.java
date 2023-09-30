package 재귀단계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P24060_알고리즘수업_병합정렬 {
    static int[] A;
    static int K, cnt = 0, ans = -1;
    static int i, j, t;
    static int[] tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int len = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        tmp = new int[len];
        mergeSort(A, 0, len - 1);
        System.out.println(ans);
        br.close();
    }

    private static void mergeSort(int[] A, int p, int r) {
        if(p < r){
            int q = (p + r) / 2;
            mergeSort(A, p, q);
            mergeSort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    private static void merge (int[] A, int p, int q, int r) {
        i = p;
        j = q + 1;
        t = p;
        while (i <= q && j <= r) {
            if(A[i] < A[j])
                tmp[t++] = A[i++];
            else
                tmp[t++] = A[j++];
        }
        while (i <= q)
            tmp[t++] = A[i++];

        while (j <= r)
            tmp[t++] = A[j++];

        i = p;

        while (i <= r) {
            cnt++;
            A[i] = tmp[i];
            if(cnt == K) {
                System.out.println(tmp[i]);
                System.exit(0);
            }
            i++;
        }
    }
}
