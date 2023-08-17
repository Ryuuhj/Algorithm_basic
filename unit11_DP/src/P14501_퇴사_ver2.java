import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14501_퇴사_ver2 {
    //dfs를 이용한 백트래킹 방식
    static int[] T, P;
    static int n, answer;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        T = new int[n];
        P = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        answer = 0;
        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int idx, int pay) {
        if (idx >= n) { //더 이상 상담이 불가능한 경우 -> pay가 최대면 answer 갱신
            answer = Math.max(pay, answer);
            return;
        }
        //idx번째 상담을 진행하는 경우
        if (idx + T[idx] <= n) // 현재 상담 가능, 페이 및 날짜 누적
            dfs(idx + T[idx], pay + P[idx]);
        else
            dfs(idx + T[idx], pay); //현재 상담 불가능 -> 페이는 누적 X
        //idx번째 상담을 진행하지 않고 다음 날 스케줄로
        dfs(idx + 1, pay);
    }
}
