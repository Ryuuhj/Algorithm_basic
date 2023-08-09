import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2775_부녀회장 {
    static int T;
    static int[] k, n;
    static int kmax, nmax;
    static int apt[][];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        k = new int[T];
        n = new int[T];
        int a=0, t = 0;
        while (t < 2 * T) {
            k[a] = Integer.parseInt(bf.readLine());
            n[a] = Integer.parseInt(bf.readLine());
            a++;
            t += 2;
        }
        kmax = Arrays.stream(k).max().getAsInt();
        nmax = Arrays.stream(n).max().getAsInt();
        //max값 구할 필요 없이 apt[15][15]로 해주어도 될 듯...

        apt = new int[kmax + 1][nmax + 1];
        for (int i = 1; i <= nmax; i++) {
            apt[0][i] = i;
        }
        for (int i = 1; i <= kmax; i++) {
            for (int j = 1; j <= nmax; j++) {
                apt[i][j] = apt[i][j - 1] + apt[i - 1][j];
            }
        }

        for (int i = 0; i < k.length; i++) {
            System.out.println(apt[k[i]][n[i]]);
        }
    }
}
