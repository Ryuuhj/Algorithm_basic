import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1012 {
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0,     1, 0, -1};
    static int T, M, N, K, x, y, cNum;
    static int[][] field;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            field = new int[M][N];
            visited = new boolean[M][N];
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                field[x][y] = 1;
            }
            cNum = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (field[i][j] == 1 && !visited[i][j]) {
                        cNum++;
                        bfs(i, j);
                    }
                }
            }
            System.out.println(cNum);
        }
    }
    private static void bfs(int x, int y) {
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(x, y));
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Pos p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx >= 0 && nx < M && ny >= 0 && ny < N && field[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.add(new Pos(nx, ny));
                    visited[nx][ny] = true;
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

