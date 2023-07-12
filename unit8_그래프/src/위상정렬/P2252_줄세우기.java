package 위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2252_줄세우기 {
    static int N, M;
    static int[] ID;
    static ArrayList<Integer>[] adjList;
    static StringBuilder answer;

    public static void out() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N+1];
        for(int i=1; i<adjList.length; i++){
            adjList[i] = new ArrayList<Integer>();
        }
        ID = new int[N+1];
        answer = new StringBuilder();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            ID[b]++;
        }
        //위상 정렬 시작
        topSort();

        System.out.println(answer);

    }

    private static void topSort() {
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<ID.length; i++){
            if(ID[i]==0)
                queue.offer(i);
        }
        while(!queue.isEmpty()){
            int now = queue.poll();
            answer.append(now+" ");
            for(int next : adjList[now]){
                if(ID[next] > 0)
                    ID[next]--;
                if(ID[next] == 0)
                    queue.offer(next);
            }
        }
    }

}
