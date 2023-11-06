package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1210_Ladder1 {
    static final int[] dx = {0, 0, -1};
    static final int[] dy = {1, -1, 0};
    static String[][] map;
    static int x, y, nx, ny;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= 10; t++) {
            br.readLine();
            map = new String[100][100];
            for (int i = 0; i < 100; i++) {
                map[i] = br.readLine().split(" ");
            }
            for (int i = 0; i < 100; i++) {
                if(map[99][i].equals("2"))
                    y = i;
            }
            x = 99;
            while (x != 0) {
                for (int i = 0; i < 3; i++) {
                    nx = x + dx[i];
                    ny = y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= 100 || ny >= 100) continue;
                    if (map[nx][ny].equals("1")) {
                        x = nx;
                        y = ny;
                        map[x][y] = "0"; //무한 반복 방지하기 위해 방문한 길 막기
                    }
                }
            }
            //최종으로 남은 y값이 사다리 시작점
            sb.append("#" + t + " " + y + "\n");
        }
        System.out.println(sb);
    }
}
