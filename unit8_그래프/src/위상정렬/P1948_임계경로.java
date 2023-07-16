package 위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1948_임계경로 {
    public static void out() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());
        StringTokenizer st;

        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adjList.add(new ArrayList<>());
        }
        ArrayList<ArrayList<int[]>> reverse = new ArrayList<>();
        for(int i=0; i<=n; i++){
            reverse.add(new ArrayList<>());
        }
        int accTime[] = new int[n+1];
        int inDegree[] = new int[n+1];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            adjList.get(a).add(new int[] {b, t});
            reverse.get(b).add(new int[] {a, t});
            inDegree[b]++;
        }
        //출발 도시, 도착 도시 입력
        st = new StringTokenizer(bf.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());
    
        //정방향 위상정렬
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startCity);
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int[] nextNode : adjList.get(now)){
                int next = nextNode[0];
                int time = nextNode[1];
                inDegree[next]--;
                accTime[next] = Math.max(accTime[next], (accTime[now]+time));
                if(inDegree[next]==0)
                    queue.offer(next);
            }
        }
        //역방향 위상정렬 전, 중복 카운팅 방지할 중복 체크 배열
        boolean[][] counted = new boolean[n+1][n+1];
        int cnt = 0;
        
        //역방향 위상정렬 -> 2번 답
        queue.clear();
        queue.offer(endCity);
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int[] preNode : reverse.get(now)){
                int previous = preNode[0];
                int time = preNode[1];
                if(((accTime[previous]+time) == accTime[now])&&!counted[now][previous]){
                    cnt++;
                    queue.offer(previous);
                    counted[now][previous] = true;
                    
                }
            }
        }

        System.out.println(accTime[endCity]);
        System.out.println(cnt);
    }
}
