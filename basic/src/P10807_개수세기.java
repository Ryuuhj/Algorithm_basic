import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10807_개수세기 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(bf.readLine());
        int nums[] = new int[N];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int v = Integer.parseInt(bf.readLine());

        int cnt = (int) Arrays.stream(nums).filter(num -> num == v).count();
        System.out.println(cnt);
    }
}
