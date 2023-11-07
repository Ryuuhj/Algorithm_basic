package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//x = col, y = row
public class P1226_미로1 {
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static char[][] maze;
    static char[] input;
    static Pos start, end;
    static int nx, ny;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= 10; t++) {
            br.readLine();
            maze = new char[16][16];
            for (int i = 0; i < 16; i++) {
                input = br.readLine().toCharArray();
                for (int j = 0; j < 16; j++) {
                    maze[i][j] = input[j];
                    if(input[j] == '2')
                        start = new Pos(j, i);
                    else if (input[j] == '3')
                        end = new Pos(j, i);
                }
            }
            int flag = bfs(start);
            sb.append("#" + t + " " + flag + "\n");
        }
        System.out.println(sb);
    }

    private static int bfs(Pos start) {
        Queue<Pos> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Pos now = queue.poll();
            for (int i = 0; i < 4; i++) {
                nx = now.x + dx[i];
                ny = now.y + dy[i];
                if (nx == end.x && ny == end.y) {
                    return 1;
                }
                if (maze[ny][nx] == '0') {
                    queue.add(new Pos(nx, ny));
                    maze[ny][nx] = '1';
                }
            }
        }
        return 0;
    }

    private static class Pos{
        int x; int y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
