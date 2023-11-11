package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1868 {
    static final int[][] dn = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
    static int T, N, min;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int k = 1; k <= T; k++) {
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            for (int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
            }
            min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] != '*') {
                        dfs(i, j, 1, map);
                        map[i][j] = '.';
                    }
                }
            }
            System.out.printf("#%d %d\n", k, min);
        }
    }

    private static void dfs(int x, int y, int cnt, char[][] origin) {
        char[][] tmp = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tmp[i][j] = origin[i][j];
            }
        }
        change(x, y, tmp);
        for (int i = x; i < N; i++) {
            for (int j = y + 1; j < N; j++) {
                if (tmp[i][j] == '.') {
                    dfs(i, j, cnt + 1, tmp);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(tmp[i][j] == '.')
                    return;
            }
        }
        min = Math.min(min, cnt);
    }
    private static void change(int x, int y, char[][] a) {
        Queue<Pos> queue = new LinkedList<>();
        for (int i = 0; i < dn.length; i++) {
            int nx = x + dn[i][0];
            int ny = y + dn[i][1];
            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if(a[nx][ny] != '*') queue.add(new Pos(nx, ny));
        }
        if (queue.size() == 8) {
            a[x][y] = 0;
            while (!queue.isEmpty()) {
                Pos p = queue.poll();
                change(p.x, p.y, a);
            }
        } else {
            a[x][y] = (char) (8 - queue.size() + '0');
        }
    }
    private static class Pos{
        int x; int y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
