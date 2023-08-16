import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14501_퇴사 {
    static int[] D, T, P;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        D = new int[N + 2]; //D[N]일때 D[N+1] = 0 값이 필요하므로 길이 +1
        T = new int[N + 1];
        P = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        //DP 진행
        for (int i = N; i > 0; i--) {
            if (i + T[i] > N + 1) { //상담 끝나는 날짜가 퇴사 이후인 경우
                D[i] = D[i + 1]; //D[N]은 자동으로 0 갱신
            }else {
                D[i] = Math.max(D[i + 1], D[i + T[i]] + P[i]);
                //i번째 스케줄 포함 X VS. i번째 스케줄 포함 O
            }
        }
        System.out.println(D[1]);
    }
}
