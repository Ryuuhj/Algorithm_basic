package 정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.IntStream;

public class P2587_대표값2 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        int avg = (int) IntStream.of(arr).average().getAsDouble();
        bw.write(avg + "\n");
        Arrays.sort(arr);
        bw.write(arr[2]+"");
        bw.close();
    }
}
