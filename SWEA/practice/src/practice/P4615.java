package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P4615 {
	static int N, M, bc, wc;
	static int x, y, stone;
	static final int[] dx = {1, 0, -1, 0, 1, -1, 1, -1};
	static final int[] dy = {0, 1, 0, -1, 1, 1, -1, -1};
	static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			board = new int[N + 1][N + 1];
			board[N / 2][N / 2] = 2;
			board[(N / 2) + 1][(N / 2) + 1] = 2;
			board[N / 2][(N / 2) + 1] = 1;
			board[(N / 2) + 1][N / 2] = 1;
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				stone = Integer.parseInt(st.nextToken());
				board[x][y] = stone;
				changeColor(x, y, stone);
			}
			bc = 0; wc = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(board[i][j] == 1) bc++;
					else if(board[i][j] == 2) wc++;
				}
			}
			sb.append("#").append(t).append(" ").append(bc).append(" ").append(wc).append("\n");

		}
		System.out.println(sb);
	}
	private static void changeColor(int x, int y, int stone) {
		int op = (stone == 1) ? 2 : 1;
		//1. 먼저 사방으로 다른 색깔 있는지 확인
		for (int i = 0; i < dx.length; i++) {
			checkStone(x+dx[i], y+dy[i], i, stone, op);
		}
		
	}
	private static void checkStone(int x, int y, int idx, int cur, int op) {
		Stack<int[]> stack = new Stack<int[]>();
		int[] point;
		while(x > 0 && y > 0 && x <= N && y <= N) { //범위 초과 전까지
			if(board[x][y] == op) {
				point = new int[] {x, y};
				stack.add(point);
			}else if(board[x][y] == 0) {
				stack.clear();
				break;
			}
			else if(board[x][y] == cur) {
				while(!stack.isEmpty()) {
					point = stack.pop();
					board[point[0]][point[1]] = cur;
				}
				break;
			}
			x += dx[idx];
			y += dy[idx];
		}
	}
	
	
	
}
