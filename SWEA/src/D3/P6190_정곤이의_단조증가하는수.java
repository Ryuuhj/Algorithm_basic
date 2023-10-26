package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class P6190_정곤이의_단조증가하는수 {
    static List<Integer> arr;
    static int N, max;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            sb.append("#").append(t + 1).append(" ");
            N = Integer.parseInt(br.readLine());
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
            Collections.sort(arr, Collections.reverseOrder());
            //단조 증가하는 수 없으면 -1 출력
            max = -1;
            for (int i = 0; i < N-1; i++) {
                for (int j = i+1; j < N; j++) {
                    int mult = arr.get(i) * arr.get(j);
                    if (isDanjo(String.valueOf(mult))) {
                        max = Math.max(max, mult);
                    }
                }
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean isDanjo(String a) {
        char[] arr = a.toCharArray();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) { //전 수가 더 큰 경우
                return false;
            }
        }
        return true;
    }
}
