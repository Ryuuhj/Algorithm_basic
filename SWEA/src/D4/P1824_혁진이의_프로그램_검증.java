package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1824_혁진이의_프로그램_검증 {
    static final int[] dr = {0, 0, 1, -1}; // 동서남북
    static final int[] dc = {1, -1, 0, 0};
    static int R, C;
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
                dfs(0, 0, 0, 0);

            System.out.printf("#%d %s\n", t, escape ? "YES" : "NO");
        }
    }

    private static void dfs(int r, int c, int dir, int mem) {
        if(escape) return;
        char cmd = arr[r][c];

        if (cmd == '@') {
            escape = true;
            return;
        }

        int nDir = dir, nMem = mem;

        if (cycle[r][c][dir][mem]) return;
        cycle[r][c][dir][mem] = true;

        if (cmd >= '0' && cmd <= '9') {
            nMem = cmd - '0';
        } else {
            switch (cmd) {
                case '>': nDir = 0; break;
                case '<': nDir = 1; break;
                case 'v': nDir = 2; break;
                case '^': nDir = 3; break;
                case '_': nDir = (mem == 0 ? 0 : 1); break;
                case '|': nDir = (mem == 0 ? 2 : 3); break;
                case '+': nMem = (mem == 15 ? 0 : mem+1); break;
                case '-': nMem = (mem == 0 ? 15 : mem-1); break;
            }
        }

        if (cmd == '?') {
            for (int i = 0; i < 4; i++) {
                if (r + dr[i] < 0) dfs(R-1, c + dc[i], i, nMem);
                else if (r + dr[i] >= R) dfs(0, c + dc[i], i, nMem);
                else if (c + dc[i] < 0) dfs(r + dr[i], C-1, i, nMem);
                else if (c + dc[i] >= C) dfs(r + dr[i], 0, i, nMem);
                else dfs(r + dr[i], c + dc[i], i, nMem);
            }
        }else {
            if (r + dr[nDir] < 0) dfs(R-1, c + dc[nDir], nDir, nMem);
            else if (r + dr[nDir] >= R) dfs(0, c + dc[nDir], nDir, nMem);
            else if (c + dc[nDir] < 0) dfs(r + dr[nDir], C-1, nDir, nMem);
            else if (c + dc[nDir] >= C) dfs(r + dr[nDir], 0, nDir, nMem);
            else dfs(r + dr[nDir], c + dc[nDir], nDir, nMem);
        }
    }
}
