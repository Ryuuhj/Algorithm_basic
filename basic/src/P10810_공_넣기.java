import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10810_공_넣기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int basket[] = new int[N];
        int i,j,k;

        while (M-- > 0) {
            st = new StringTokenizer(bf.readLine());
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            //int finalK = k;
            for (int l = i-1; l <j ; l++) {
                basket[l] = k;
            }
        }

        for (int num : basket) {
            bw.write(num+" ");
        }
        bw.close();
    }
}
