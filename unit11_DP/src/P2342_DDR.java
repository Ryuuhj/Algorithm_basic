import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P2342_DDR {
    static int[][][] dp;
    static ArrayList<Integer> steps;
    static int length;
    static int[][] values = {
            {0, 2, 2, 2, 2},
            {2, 1, 3, 4, 3},
            {2, 3, 1, 3, 4},
            {2, 4, 3, 1, 3},
            {2, 3, 4, 3, 1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        dp = new int[100001][5][5];
        steps = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        while (true) {
            int n = Integer.parseInt(st.nextToken());
            if (n == 0)
                break;
            steps.add(n);
        }
        length = steps.size(); //이동 횟수
        int result = getDDR(0, 0, 0);

        System.out.println(result);

    }

    private static int getDDR(int now, int l, int r) {
        if (now == length)
            return 0; //끝까지 도달한 경우(초기) => 0부터 시작해나감
        //그 이전 값 존재하면 리턴 (추가 힘 누적해서 계산해야 하므로)
        if (dp[now][l][r] != 0) {
            return dp[now][l][r];
        }
        int next = steps.get(now); //다음 스텝
        //왼발로 next 밟는 경우 vs 오른발로 next 밟는 경우 중 최소로 갱신
        int leftV = getDDR(now + 1, next, r) + values[l][next];
        int rightV = getDDR(now + 1, l, next) + values[r][next];
        dp[now][l][r] = Math.min(leftV, rightV);

        return dp[now][l][r];
    }


}
