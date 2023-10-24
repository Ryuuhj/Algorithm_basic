package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P1873_상호의_배틀필드 {
    static StringTokenizer st;
    static String[][] field;
    static int W, H;
    static List<String> direction = Arrays.asList("U", "D", "R", "L");
    static List<String> tank = Arrays.asList("^", "v", ">", "<");

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int ti, tj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            sb.append("#").append(t + 1).append(" ");
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            field = new String[H][W];
            for (int i = 0; i < H; i++) {
                field[i] = br.readLine().split("");
                for (int j = 0; j < W; j++) {
                    if (field[i][j].equals("<") || field[i][j].equals(">") || field[i][j].equals("^") || field[i][j].equals("v")) {
                        ti = i;
                        tj = j;
                    }
                }
            }
            int N = Integer.parseInt(br.readLine());
            String[] cmd = br.readLine().split("");
            for (int i = 0; i < N; i++) {
                doCmd(cmd[i]);
            }
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    sb.append(field[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void doCmd(String cmd) {
        if (cmd.equals("S")) {
            int idx = tank.indexOf(field[ti][tj]);
            int sr = ti + dr[idx], sc = tj + dc[idx];
            while ((sr >= 0 && sr < H) && (sc >= 0 && sc < W)) {
                if (field[sr][sc].equals("*")) {
                    field[sr][sc] = ".";
                    return;
                } else if (field[sr][sc].equals("#")) {
                    return;
                }
                sr += dr[idx];
                sc += dc[idx];
            }
        } else {
            int idx = direction.indexOf(cmd);
            field[ti][tj] = tank.get(idx);
            int nr = ti + dr[idx];
            int nc = tj + dc[idx];
            if ((nr >= 0 && nr < H) && (nc >= 0 && nc < W)) {
                if (field[nr][nc].equals(".")) {
                    field[nr][nc] = field[ti][tj];
                    field[ti][tj] = ".";
                    ti = nr; tj = nc;
                }
            }
        }
    }

}
