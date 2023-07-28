package 최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class P17472_다리만들기2 {
    static int n, m, landNum;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<ArrayList<int[]>> landList;
    static ArrayList<int[]> pointList;
    static int[][] map;
    static int[] parent;
    static boolean[][] visited;
    static PriorityQueue<Bridge> eQueue;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String input = bf.readLine();
            map[i] = Stream.of(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        //bfs로 섬 확정
        landNum = 1; //땅 번호 1번부터 시작
        landList = new ArrayList<>();//섬에 해당하는 좌표 리스트들 모두 담아놓을 리스트

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //1이고, 방문하지 않은 모든 좌표에 대해 bfs 탐색 시작
                if (map[i][j] != 0 && !visited[i][j]) {
                    BFS(i, j);
                    //한번 bfs 실행될 때 마다 섬 하나씩 결정되어 landList에 추가됨
                    landList.add(pointList);
                    landNum++;
                    //System.out.println("landNum>>>>"+landNum);
                }
            }
        }

        eQueue = new PriorityQueue<>();
        //섬 확정 -> 각 섬에서 가능한 다리(에지) 탐색 후 edgeQueue에 추가
        for (int i = 0; i < landList.size(); i++) {
            ArrayList<int[]> island = landList.get(i);
            for (int[] coordinate : island) {
                conquerBridge(coordinate[0], coordinate[1], eQueue);
            }
        }
        //정렬된 edgeQueue에 대해 크루스칼 알고리즘 실행
        parent = new int[landNum]; //landNum+1 이 아닌 이유 >> 이미 +1된 상태에서 빠져나오므로
        Arrays.setAll(parent, e -> e);

        int answer = kruskal();
        System.out.println(answer);

    }

    private static int kruskal() {
        int accValue = 0, edgeCount = 0;
        while (!eQueue.isEmpty()) {
            Bridge nowBridge = eQueue.poll();
            //System.out.println("start: " + nowBridge.start + " end: " + nowBridge.end + " value : " + nowBridge.value);
            if (find(nowBridge.start) != find(nowBridge.end)) {
                union(nowBridge.start, nowBridge.end);
                accValue += nowBridge.value;
                edgeCount++;
            }
        }
        //!에지가 n-1개 아닐 수도 있음!! ==> 최소 신장 트리가 존재하지 않는 것!! 따로 처리해줘야 한다!!!!!
        if(edgeCount == landNum-2)//== "edgeCount = V-1"
            return accValue;
        else
            return -1;
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }

    private static void conquerBridge(int i, int j, PriorityQueue<Bridge> eQueue) {
        int nowLN = map[i][j];
        for (int d = 0; d < dx.length; d++) { //어떤 섬에 속하는 한 점에서, 4방향 직선으로 쭈우욱 밀고나감
            int tmpX = dx[d];
            int tmpY = dy[d];
            int length = 0;
            while (i + tmpX >= 0 && i + tmpX < n && j + tmpY >= 0 && j + tmpY < m) {
                int tmpLN = map[i + tmpX][j + tmpY];
                if (tmpLN == nowLN) break;
                else if (tmpLN != 0){
                    if (length > 1)
                        eQueue.add(new Bridge(nowLN, tmpLN, length));
                    break;
                }else
                    length++;
                if(tmpX < 0) tmpX--; //dx = -1인 경우 -> -2로
                else if (tmpX > 0) tmpX++;
                else if (tmpY < 0) tmpY--;
                else if (tmpY > 0) tmpY++;
            }
        }
    }

    //연결 섬 찾는용 (1개씩)
    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        pointList = new ArrayList<>();
        //특정 섬을 탐색할 시작 좌표 세팅 (큐에 더하고, 리스트에도 넣고 시작)
        addPoint(i, j, queue);
        /*int[] startPoint = {i, j};
        queue.add(startPoint);
        pointList.add(startPoint);
        visited[i][j] = true;
        map[i][j] = landNum;*/

        while (!queue.isEmpty()) {
            int[] now = queue.poll(); //{i, j}
            int x = now[0];
            int y = now[1];

            for (int k = 0; k < 4; k++) {
                int tmpX = dx[k];
                int tmpY = dy[k];
                //지도 범위를 벗어나지 않는 한에서 좌표 확장시켜 점점 이동
                while (x + tmpX >= 0 && x + tmpX < n && y + tmpY >= 0 && y + tmpY < m) {
                    //만약 한칸 옮겨간 좌표가 섬에 해당하며, 처음 방문하는 곳이라면
                    if (map[x + tmpX][y + tmpY] == 1 && !visited[x + tmpX][y + tmpY]) {
                        addPoint(x + tmpX, y + tmpY, queue);
                    }else break; //아니라면 해당 방향은 텄음, 탈출
                    //좌표 하나씩 조정해나가기
                    if(tmpX < 0) tmpX--; //dx = -1인 경우 -> -2로
                    else if (tmpX > 0) tmpX++;
                    else if (tmpY < 0) tmpY--;
                    else if (tmpY > 0) tmpY++;
                }
            }
        }
    }

    //좌표 (i, j)를 해당 특정 섬의 좌표로 넣어줌
    private static void addPoint(int i, int j, Queue<int[]> queue) {
        visited[i][j] = true;
        map[i][j] = landNum; //표처럼 1 대신 특정 섬 번호로 값 교체

        int[] coordinate = {i, j};
        pointList.add(coordinate);
        queue.add(coordinate); //가능한 모든 좌표에 대해 섬 검사 = BFS
    }

    private static class Bridge implements Comparable<Bridge>{
        int start;
        int end;
        int value;
        Bridge(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }


        @Override
        public int compareTo(Bridge o) {
            return this.value - o.value;
        }
    }
}
