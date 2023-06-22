package BFS;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class P2178_미로찾기 {
    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N, M;

    public static void out() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        visited = new boolean[N][M];
        //값 추가
        for(int i=0; i<N; i++){
            maze[i] = Stream.of(bf.readLine().split(""))
            .mapToInt(Integer::parseInt).toArray();
        }

        bfsMaze(0,0);
        System.out.println(maze[N-1][M-1]);

    }

    private static void bfsMaze(int i, int j) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(i, j));
        visited[i][j]=true;
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            for(int k=0;k<dx.length;k++){
                int x = pair.x + dx[k];
                int y = pair.y + dy[k];
                //좌표 조건 선 검사
                if((x>=0) || (y>=0) || (x<N) || (y<M)){
                    if(!visited[x][y]&& maze[x][y]==1){
                        queue.offer(new Pair(x, y));
                        visited[x][y] = true;
                        maze[x][y] = maze[pair.getX()][pair.getY()] + 1;
                    }
                }
            }
        }
    }
    
    private static class Pair{
        int x, y;
        
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
    }
}
