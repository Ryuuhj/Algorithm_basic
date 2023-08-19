import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P13398_연속합2 {
    static int n;
    static int[] arr;
    static long[] L, R, delete;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n];
        L = new long[n];
        R = new long[n];
        delete = new long[n];

        st = new StringTokenizer(bf.readLine());
        if (n == 1) {
            System.out.println(st.nextToken());
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //L 생성
        L[0] = arr[0];
        for (int i = 1; i < n; i++) {
            L[i] = Math.max(L[i - 1] + arr[i], arr[i]);
        }
        //R 구간합은 방향 반대로!!
        R[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            R[i] = Math.max(R[i + 1] + arr[i], arr[i]);
        }

        //최대값 먼저 생성
        long max = Arrays.stream(L).max().getAsLong();

        //본인 제외 최대값 생성
        delete[0] = R[1];
        delete[n - 1] = L[n - 2];
        for (int i = 1; i < n - 1; i++) {
            delete[i] = L[i - 1] + R[i + 1];
        }
        //delete의 최대값과 비교 후 최종 확정 => 출력
        long delMax = Arrays.stream(delete).max().getAsLong();

        max = Math.max(max, delMax);
        System.out.println(max);
    }
}
