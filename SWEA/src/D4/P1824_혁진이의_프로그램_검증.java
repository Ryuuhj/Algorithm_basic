package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1824_혁진이의_프로그램_검증 {
    static final int[] dx = {0, 0, 1, -1}; // 동서남북
    static final int[] dy = {1, -1, 0, 0};
    static int R, C, nx, ny, nDir, nMem;
    static char[][] arr;
    static char[] input;
    static boolean[][][][] cycle;
    static boolean escape;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            arr = new char[R][C];
            cycle = new boolean[R][C][4][16]; //mem = 0 ~ 15 까지 16개
            escape = false;
            boolean existEnd = false;

            for (int i = 0; i < R; i++) {
                input = br.readLine().toCharArray();
                for (int j = 0; j < C; j++) {
                    if (input[j] == '@') existEnd = true; //멈출 가능성 O
                    arr[i][j] = input[j];
                }
            }
            if(existEnd)
                bfs(0, 0, 0, 0);

            System.out.printf("#%d %s\n", t, escape ? "YES" : "NO");
        }
    }

    private static void bfs(int r, int c, int dir, int mem) {
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(r, c, dir, mem));
        while (!queue.isEmpty()) {
            Pos p = queue.poll();
            if (arr[p.x][p.y] == '@') {
                escape = true;
                return;
            }
            if (cycle[p.x][p.y][p.dir][p.mem]) continue; //return이 아니라 다음 좌표로
            cycle[p.x][p.y][p.dir][p.mem] = true;
            char cmd = arr[p.x][p.y];
            nx = p.x; ny = p.y; nDir = p.dir; nMem = p.mem;
            if (cmd >= '0' && cmd <= '9') {
                nMem = cmd - '0';
            } else {
                switch (cmd) {
                    case '>': nDir = 0; break;
                    case '<': nDir = 1; break;
                    case 'v': nDir = 2; break;
                    case '^': nDir = 3; break;
                    case '_': nDir = nMem == 0 ? 0 : 1; break;
                    case '|': nDir = nMem == 0 ? 2 : 3; break;
                    case '?':
                        for (int d = 0; d < 4; d++) {
                            queue.add(new Pos(nx+dx[d], ny + dy[d], d, nMem));
                        }
                        break;
                    case '+': nMem = nMem == 15 ? 0 : nMem + 1; break;
                    case '-': nMem = nMem == 0 ? 15 : nMem - 1; break;
                }
            }
            if(cmd != '?')
                queue.add(new Pos(nx+dx[nDir], ny + dy[nDir], nDir, nMem));
        }

    }
    static class Pos {
        int x; int y; int dir; int mem;

        Pos(int x, int y, int dir, int mem) {
            if(x < 0) x = R-1;
            else if (x >= R) x = 0;
            else if (y < 0) y = C - 1;
            else if(y >= C) y = 0;
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.mem = mem;
        }
    }


}
