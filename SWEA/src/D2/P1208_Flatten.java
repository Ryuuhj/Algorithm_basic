package D2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P1208_Flatten {
    static ArrayList<Integer> boxes;
    static int N, max, min;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = 10;

        for (int i = 1; i <= T; i++) {
            sb.append("#").append(i).append(" ");
            N = sc.nextInt(); //덤프 횟수
            boxes = new ArrayList<>();
            for (int j = 0; j < 100; j++) {
                boxes.add(sc.nextInt());
            }
            boxes.sort(Collections.reverseOrder());
            while (N-- > 0) {
                max = boxes.get(0);
                min = boxes.get(99);
                boxes.set(0, max - 1);
                boxes.set(99, min + 1);
                boxes.sort(Collections.reverseOrder());
            }
            sb.append(boxes.get(0) - boxes.get(99)).append("\n");
        }
        System.out.println(sb);
    }
}
