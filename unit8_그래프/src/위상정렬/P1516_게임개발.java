package 위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1516_게임개발 {
    static int N;
    static ArrayList<ArrayList<Integer>> adjList;
    static int D[];
    static int T[];
    static int dTime[];

    public static void out() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(bf.readLine());
        //배열들 초기화
        adjList = new ArrayList<>();
        for(int i=0; i<=N; i++){
            adjList.add(new ArrayList<>());
        }
        D = new int[N+1];
        T = new int[N+1];
        dTime= new int[N+1];

        //buildings = new Building[N+1];
        //입력 값 바탕으로 노드 정보 채우기
        for(int k=1; k<=N; k++){
            st = new StringTokenizer(bf.readLine());
            dTime[k] = Integer.parseInt(st.nextToken());
            while(true){
                int p = Integer.parseInt(st.nextToken());
                if(p == -1) 
                    break;
                adjList.get(p).add(k);
                D[k]+=1;
            }
        }
        
        
        //인접 리스트 돌며 위상정렬
        topSort();

        //T배열 한 줄씩 출력
        for(int i=1; i<T.length; i++){
            System.out.println(T[i]);
        }
    }

    private static void topSort() {
        Queue<Integer> queue = new LinkedList<>(); 
        for(int i=1; i<D.length; i++){
            if(D[i]==0)
                queue.offer(i);
                T[i] = dTime[i];
        }
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int next : adjList.get(now)){
                D[next]--;
                T[next] = Math.max(T[next], T[now]+dTime[next]);
                if(D[next] == 0){
                    queue.offer(next);
                }
            }
        }
    }
}

