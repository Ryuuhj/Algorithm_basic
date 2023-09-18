package 정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1427_소트인사이드 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] A = Arrays.stream(bf.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(A);

        for (int i = A.length - 1; i >= 0; i--) {
            System.out.print(A[i]);
        }
    }
}
