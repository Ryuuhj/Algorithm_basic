import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2166_다각형의_면적 {
    static StringTokenizer st;
    static int N;
    static long[] x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        x = new long[N + 1];
        y = new long[N + 1];
        double area = 0;
        for (int i = 0; i < N ; i++){
            st = new StringTokenizer(bf.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        //처음 좌표로 마무리
        x[N] = x[0];
        y[N] = y[0];
        //평행사변형 너비 구해서 모두 더함
        for (int i = 0; i < N; i++) {
            area += ((x[i] * y[i + 1]) - (x[i + 1] * y[i]));
        }
        System.out.println(String.format("%.1f", Math.abs(area)/2.0));

    }

}
