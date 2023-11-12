package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1868 {
    static final int[][] dn = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
    static int T, N, nx, ny, cnt;
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int k = 1; k <= T; k++) {
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            visited = new boolean[N][N];
            cnt = 0;
            for (int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '.') {
                        getC(i, j);
                    }
                }
            }
            for (int i = 0; i < N; i++) { //나머지 단일로 눌러야 하는 칸 찾기
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] == '.') {
                        cnt++;
                    }
                }
            }
            System.out.printf("#%d %d\n", k, cnt);
        }
    }

    private static void getC(int x, int y) {
        if(visited[x][y] || !isClear(x, y)) return;
        cnt++;
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(x, y));
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Pos p = queue.poll();
            //visited[p.x][p.y] = true;
            for (int i = 0; i < 8; i++) {
                nx = p.x + dn[i][0];
                ny = p.y + dn[i][1];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] == '.') {
                    visited[nx][ny] = true;
                    if(isClear(nx, ny))
                        queue.add(new Pos(nx, ny));
                }
            }
        }
    }

    private static boolean isClear(int x, int y) {
        int bomb = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dn[i][0];
            int ny = y + dn[i][1];
            if(nx >= 0 && nx < N && ny >= 0 && ny < N
                    && map[nx][ny] == '*') bomb++;
        }
        if(bomb != 0) return false;
        return true;
    }


    private static class Pos {
        int x;
        int y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
