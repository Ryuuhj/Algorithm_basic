package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1226 {
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int T, ans;
    static char[][] maze;
    static boolean[][] visited;
    static Pos start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10; t++) {
            br.readLine();
            maze = new char[16][16];
            visited = new boolean[16][16];
            start = null; end = null;
            ans = 0;
            for (int i = 0; i < 16; i++) {
                maze[i] = br.readLine().toCharArray();
                for (int j = 0; j < 16; j++) {
                    if (maze[i][j] == '2')
                        start = new Pos(i, j);
                    else if(maze[i][j] == '3')
                        end = new Pos(i, j);
                }
            }
            if (start != null && end != null) {
                bfs(start);
            }
            System.out.printf("#%d %d\n", t, ans);
        }
    }

    private static void bfs(Pos start) {
        Queue<Pos> queue = new LinkedList<>();
        visited[start.x][start.y] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            Pos p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || nx >= 16 || ny < 0 || ny >= 16 || visited[nx][ny] || maze[nx][ny] == '1') continue;
                if (nx == end.x && ny == end.y) {
                    ans = 1;
                    return;
                }
                visited[nx][ny] = true;
                queue.add(new Pos(nx, ny));
            }
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
