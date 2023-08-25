import java.util.Arrays;
import java.util.Scanner;

public class P2342_DDR_2 {
    //Bottom-up 방식
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int dp[][][] = new int[100001][5][5];
        //발 위치 별 드는 힘 모음
        int values[][] = {
                {0, 2, 2, 2, 2},
                {2, 1, 3, 4, 3},
                {2, 3, 1, 3, 4},
                {2, 4, 3, 1, 3},
                {2, 3, 4, 3, 1}
        };
        int INF = 100001 * 4;
        //dp 초기화
        for (int i = 0; i < 100001; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], INF);
            }
        }
        //초기값 0으로 세팅
        dp[0][0][0] = 0;
        //수열 하나씩 받아와 모든 경우의 수 따져서 최솟값 갱신
        int next = 0, s = 1; //s-> 수열 중 몇 번째인지

        while (true) {
            next = sc.nextInt();
            if (next == 0) //끝 일경우 종료
                break;
            //왼발이 next로 이동하는 경우-> 오른발 값(0~4)에 따른 경우의 수
            //왼 i, 오 j
            for (int j = 0; j < 5; j++) {
                if (j == next)  //오른발 위치 != 왼발 위치
                    break;
                for (int i = 0; i < 5; i++) { //왼발 j -> n인 경우 힘 최솟값 저장
                    dp[s][next][j] = Math.min(dp[s - 1][i][j] + values[i][next], dp[s][next][j]);
                }
            }
            //오른발이 next로 이동하는 경우 -> 왼발 값(0~4)에 따른 경우의 수
            for (int i = 0; i < 5; i++) {
                if (i == next)  //왼발 위치 != 오른발 위치
                    break;
                for (int j = 0; j < 5; j++) { //오른발 i -> n인 경우 힘 최솟값 저장
                    dp[s][i][next] = Math.min(dp[s - 1][i][j] + values[j][next], dp[s][i][next]);
                }
            }
            //왼발, 오른발에 대해서 모든 탐색 끝났으면 다음 수열로 업데이트
            s++;
        }
        //while문 빠져나올때 s+1인 상태이므로 -1로 복구
        s--;
        //dp[s][][]일 경우 최솟값 출력
        int minResult = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                minResult = Math.min(minResult, dp[s][j][i]);
            }
        }
        System.out.println(minResult);
    }
}
