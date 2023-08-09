import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1010_다리놓기 {
    static int t, n, m;
    static int[][] D;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(bf.readLine());
        D = new int[30][30];
        for (int i = 1; i < 30; i++) {
            D[i][0] = 1;
            D[i][1] = i;
            D[i][i] = 1;
        }
        //배열 채우기
        for (int i = 1; i < 30; i++) {
            for (int j = 2; j <= i; j++) {
                D[i][j] = D[i - 1][j] + D[i - 1][j - 1];
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            ans.append(D[m][n] + "\n");
        }
        System.out.print(ans);
    }
}
