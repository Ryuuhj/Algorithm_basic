import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2098_외판원순회 {
    static StringTokenizer st;
    static final int INF = 11000000;
    static int N;
    static int[][] W, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        W = new int[N][N];
        dp = new int[N][(1 << N) - 1];
        //dp 초기화
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        //비용 행렬 채우기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(tsp(0, 1));
    }

    private static int tsp(int current, int visit) {
        //모든 도시를 방문한 경우 -> 시작 도시로 마지막 카운트
        if (visit == (1 << N) - 1) {
            //출발 도시로 사이클 생성되지 않는 예외 처리
            if (W[current][0] == 0) return INF;
            return W[current][0]; //사이클 맺기 위해 시작 도시로 가는 비용 마지막으로 +
        }
        //이미 해당 경로에서 남은 최솟값을 기록해놓은 경우
        if(dp[current][visit] != -1)
            return dp[current][visit];
        //새로 개척하는 경우 -> 나머지 방문 가능한 모든 도시에 대해 잔여 비용 구하고 최솟값 갱신
        dp[current][visit] = INF; //Math.min 비교를 위해 dp[current][visit]값 다시 INF로 초기화

        for (int i = 0; i < N; i++) {
            //방문한 기록 없음 && 해당 노드로 가는 간선 있는 경우에 대해서만 값 갱신
            if ((visit & (1 << i)) == 0 && (W[current][i] != 0)) {
                dp[current][visit] = Math.min(dp[current][visit], tsp(i, visit | (1 << i)) + W[current][i]);
            }
        }
        return dp[current][visit];
    }
}
