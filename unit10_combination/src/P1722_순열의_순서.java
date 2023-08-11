import java.util.Arrays;
import java.util.Scanner;

public class P1722_순열의_순서 {
    static int N, Q;
    static boolean[] visited;
    static long[] factorial;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        factorial = new long[21];
        visited = new boolean[21];
        Arrays.fill(factorial, 1);
        for (int i = 1; i < factorial.length; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        N = sc.nextInt();
        Q = sc.nextInt();

        String ans = query(Q);
        System.out.println(ans);
    }

    private static String query(int q) {
        StringBuilder ans = new StringBuilder();
        if (q == 1) {
            long K = sc.nextLong();
            for (int i = 0; i < N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (visited[j]) continue;
                    if (K > factorial[N - i - 1]) {
                        K -= factorial[N - i - 1];
                    } else {
                        ans.append(j+" ");
                        visited[j] = true;
                        break;
                    }
                }
            }
        } else if (q == 2) {
            int[] nums = new int[N+1];
            long K = 1;
            for (int i = 1; i <= N; i++) {
                nums[i] = sc.nextInt();
                long s = 0;
                for (int j = 1; j < nums[i]; j++) {
                    if(visited[j]) continue;
                    s++; //각 자릿수가 남은 수 중 몇번째인지 카운트
                }
                K += s * factorial[N - i];
                visited[nums[i]] = true;
            }
            ans.append(K);
        }
        return ans.toString();
    }
}
