package 이차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class P2566_최댓값 {

    static String[] maxArr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int maxRow = 1;
        int maxColumn = 1;

        for (int i = 1; i <= 9; i++) {
            String[] row = bf.readLine().split(" ");
            IntStream s = Arrays.stream(row).mapToInt(Integer::parseInt);
            int tmpMax = s.max().getAsInt();
            if (tmpMax > max) {
                max = tmpMax;
                maxRow = i;
                maxColumn = Arrays.asList(row).indexOf((max + "")) + 1; //int->String
            }
        }
        System.out.println(max);
        System.out.println(maxRow + " " + maxColumn);
    }
}
