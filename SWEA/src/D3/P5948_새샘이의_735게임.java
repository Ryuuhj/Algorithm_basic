package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P5948_새샘이의_735게임 {
    static Set<Integer> list;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            sb.append("#").append(t + 1).append(" ");
            list = new HashSet<>();
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            combine(0, 0, 3);
            List<Integer> sorted = new ArrayList<>(list);
            Collections.sort(sorted, Collections.reverseOrder());//중복 제거 후 정렬
            sb.append(sorted.get(4)).append("\n");
        }
        System.out.println(sb);
    }

    private static void combine(int idx, int accSum, int cnt) {
        if (cnt == 0) { //combine(7, 14, 0) 인 경우(마지막 수가 조합에 포함되는 경우) 예외처리 필요 -> cnt 조건 먼저
            list.add(accSum);
            return;
        }
        if(idx > 6)
            return;

        combine(idx + 1, accSum + arr[idx], cnt - 1);
        combine(idx + 1, accSum, cnt);
    }
}
