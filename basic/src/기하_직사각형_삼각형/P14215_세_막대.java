package 기하_직사각형_삼각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P14215_세_막대 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] stick = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int sum = Arrays.stream(stick).sum();
        Arrays.sort(stick);

        if (stick[2] >= (stick[1] + stick[0])) {
            sum -= (stick[2] - (stick[1] + stick[0])+1);
        }
        System.out.println(sum);

    }
}
