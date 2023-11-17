package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1249 {
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int T, N, min;
    static int[][] map, tmpMin;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            tmpMin = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(tmpMin[i], Integer.MAX_VALUE);
            }
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            }
            bfs(0, 0);
            System.out.printf("#%d %d\n", t, tmpMin[N-1][N-1]);
        }
    }

    private static void bfs(int x, int y) {
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(x, y));
        visited[x][y] = true;
        tmpMin[x][y] = map[x][y];
        while (!queue.isEmpty()) {
            Pos now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N){ //방문 검사를 없애야 갱신 가능
                    if(tmpMin[nx][ny] <= tmpMin[now.x][now.y] + map[nx][ny]) continue;
                    tmpMin[nx][ny] = tmpMin[now.x][now.y] + map[nx][ny];
                    queue.add(new Pos(nx, ny));
                }
            }
        }
    }

    private static class Pos {
        int x; int y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
