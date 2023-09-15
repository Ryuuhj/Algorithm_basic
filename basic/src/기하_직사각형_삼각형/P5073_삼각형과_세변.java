package 기하_직사각형_삼각형;

import java.io.*;
import java.util.Arrays;

public class P5073_삼각형과_세변 {
    static int[] s;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            s = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (s[0] == 0) {
                break;
            }
            Arrays.sort(s);
            if (s[2] >= (s[1] + s[0])) {
                bw.write("Invalid\n");
            } else {
                if (s[0] == s[1] && s[0] == s[2]) {
                    bw.write("Equilateral\n");
                } else if ((s[0] != s[1] && s[1] != s[2]) && s[0] != s[2]) {
                    bw.write("Scalene\n");
                } else {
                    bw.write("Isosceles\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
