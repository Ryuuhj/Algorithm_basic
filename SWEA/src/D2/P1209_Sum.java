package D2;

import java.util.Arrays;
import java.util.Scanner;

public class P1209_Sum {
    static int[] col, row, dia;
    static int tmp;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = 10;
        //각 열의 합 -> int col[100]에 col[j]++, row는 한 줄마다 합 구해 row[i]에 넣기
        //대각선은 i+j==100인 경우 기울기-, i==j면 + ,,, 따라 추가 dia[0]-> 음수 dia[1]>양수
        while (T-- > 0) {
            sb.append("#").append(sc.nextInt()).append(" ");
            col = new int[100];
            row = new int[100];
            dia = new int[2];

            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    tmp = sc.nextInt();
                    col[j] += tmp;
                    row[i] += tmp;
                    if (i + j == 100) {//음수
                        dia[0] += tmp;
                    }
                    if (i == j) {
                        dia[1] += tmp;
                    }
                }
            }
            //최댓값 각각 구해 최대 출력
            int m1 = Arrays.stream(col).max().getAsInt();
            int m2 = Arrays.stream(row).max().getAsInt();
            int m3 = Math.max(dia[0], dia[1]);
            sb.append(Math.max(m1, Math.max(m2, m3))).append("\n");
        }
        System.out.println(sb);

    }

}
