package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P4615_재미있는_오셀로게임 {
    static StringTokenizer st;
    static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
    static int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};
    static int[] stone = {0, 2, 1};
    static int N, M;
    static int[][] board;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            sb.append("#").append(t + 1).append(" ");
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            board = new int[N+1][N+1]; //row=x, col=y
            cnt = new int[]{0, 2, 2};
            //정 가운데 배치하고 시작
            board[N/2+1][N/2+1] = 2;
            board[N/2][N/2] = 2;
            board[N/2+1][N/2] = 1;
            board[N/2][N/2+1] = 1;

            while (M-- > 0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int color = Integer.parseInt(st.nextToken());
                putStone(x, y, color);
                if ((cnt[1] + cnt[2]) == N * N) {
                    break;
                }
            }
            sb.append(cnt[1]).append(" ").append(cnt[2]).append("\n");
        }
        System.out.println(sb);
    }

    private static void putStone(int row, int col, int bw) {
        int tmp = cnt[bw];

        for (int idx = 0; idx < 8; idx++) {
            searchDir(row, col, bw, idx);
        }
        //변경 하나라도 됐으면 cnt[bw] 값이 달라짐
        if (tmp < cnt[bw]) {
            board[row][col] = bw;
            cnt[bw]++;
        }
    }

    private static void searchDir(int x, int y, int bw, int dir) {
        Stack<Point> stack = new Stack<>();
        for (int k = 1; k < N; k++) {
            int nx = x + k * dx[dir];
            int ny = y + k * dy[dir];
            if (!(nx <= 0 || nx > N || ny <= 0 || ny > N)) { //제한 범위 내에서
                if(board[nx][ny] == 0)
                    break;
                else if (board[nx][ny] == bw) { //같은 색인 경우
                    while (!stack.empty()) { //그 사이 칸 모두 변경
                        Point p = stack.pop();
                        board[p.x][p.y] = bw;
                        cnt[bw]++;
                        cnt[stone[bw]]--;
                    }
                    break; //사이 밖은 상관 x므로 탈출
                } else { //다른 색일 경우 후보로 넣음
                    stack.push(new Point(nx, ny));
                }
            }
        }
    }
    private static class Point{
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
