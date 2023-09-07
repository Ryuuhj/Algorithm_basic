import java.io.*;
import java.util.StringTokenizer;

public class P15552_빠른AB {
    static StringTokenizer st;
    static int a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(bf.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            //bw.write(a + b + "\n");
            sb.append(a + b + "\n");
        }
        //bw.close();
        System.out.println(sb);
    }
}
