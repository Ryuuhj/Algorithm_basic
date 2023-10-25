package D3;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P6808_규영이와_인영이의_카드게임 {
    static List<Integer> KC, YC;
    static boolean[] visited;
    static int KW, KL;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            YC = IntStream.range(1, 19).boxed().collect(Collectors.toList());
            KC = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList()); //규영 카드
            YC.removeAll(KC); //차집합으로 인영이 카드 세팅
            visited = new boolean[9];
            KW = 0; KL = 0; //횟수 초기화

            dfs(0, 0, 0, 0);
            sb.append("#").append(t + 1).append(" ").append(KW).append(" ").append(KL).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int idx, int depth, int K, int Y) {
        if (depth == 9) {
            if(K > Y) KW++;
            else if (K < Y) KL++;
            return;
        }
        if(idx > 8) return;

        for (int i = 0; i < 9; i++) {
            if (!visited[i]) {
                int tmp = YC.get(i) + KC.get(idx);
                visited[i] = true;
                if(YC.get(i) < KC.get(idx))
                    dfs(idx + 1, depth + 1, K + tmp, Y);
                else
                    dfs(idx + 1, depth + 1, K, Y + tmp);
                visited[i] = false;
            }
        }
    }
}
