import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14003_긴_증가_부분수열5 {
    static StringTokenizer st;
    static int N, maxL;
    static int[] A = new int[1000001];
    static int[] B = new int[1000001];
    static int[] dp = new int[1000001];
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        //A 저장
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        //dp 채우기 전 초기값 설정
        B[1] = A[1]; dp[1] = 1;
        maxL = 1;
        int idx;
        //A[2] ~ A[N] 탐색 -> B[]값 이용해 dp 갱신
        for (int i = 2; i <= N; i++) {
            if (B[maxL] < A[i]) {
                maxL++;
                B[maxL] = A[i];
                dp[i] = maxL;
            } else {
                idx = binSearch(1, maxL, A[i]);
                B[idx] = A[i];
                dp[i] = idx;
            }
        }
        //출력 1 : 최장 길이 출력
        System.out.println(maxL);
        //출력 2 : 최장 수열 출력
        answer = new int[maxL + 1];
        for (int i = N; i >= 1; i--) {
            if (dp[i] == maxL) {
                answer[maxL] = A[i];
                maxL--;
            }
        }
        for (int i = 1; i < answer.length; i++) {
            System.out.print(answer[i]+" ");
        }
    }

    private static int binSearch(int left, int right, int target) {
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (B[mid] < target) { //타겟이 더 큰 경우 -> 오른쪽 탐색
                left = mid + 1;
            } else { //타겟이 작거나 같은 경우 -> 왼쪽 탐색
                right = mid;
                //같으면 결국 right(=mid)로 수렴, 반환 -> 덮어쓰기 , 작으면 idx+1 반환
            }
        }
        return left;
    }
}
