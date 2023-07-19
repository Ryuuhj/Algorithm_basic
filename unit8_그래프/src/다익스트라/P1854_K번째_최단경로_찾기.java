package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1854_K번째_최단경로_찾기 {
    static int n, m, k;

    public static void out() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[][] W = new int[n+1][n+1];
        PriorityQueue<Integer>[] distQ = new PriorityQueue[n+1];
        PriorityQueue<City> pq = new PriorityQueue<>();
        //내림차순 정의할 Comparator
        Comparator<Integer> comparator = new Comparator<Integer>(){
            @Override
            public int compare (Integer o1, Integer o2){
                return o1 > o2 ? -1 : 1;
            }
        };
        //distQ 초기화
        for(int i=1; i<=n; i++){
            distQ[i] = new PriorityQueue<>(k, comparator);
        }
        //에지 채우기
        while(m-->0){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            W[a][b] = c;
        }
        //다익스트라 실행
        pq.add(new City(1, 0));
        distQ[1].add(0);
        while(!pq.isEmpty()){
            City now = pq.poll();
            for(int next=1; next<=n; next++){
                if(W[now.num][next]==0) continue;
                
                int newValue = now.cost + W[now.num][next];
                if(distQ[next].size() < k){
                    distQ[next].add(newValue);
                    pq.add(new City(next, newValue));
                }else if(distQ[next].peek() > newValue){
                    distQ[next].poll(); //하나 제거 후!
                    distQ[next].add(newValue);
                    pq.add(new City(next, newValue));
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for(int i=1; i<=n; i++){
            if(distQ[i].size()==k){ //큐가 차있음 = k번째 값 존재
                ans.append(distQ[i].peek()+"\n");
            }else{
                ans.append("-1\n");
            }
        }
        System.out.print(ans);
    
    }
    
}
class City implements Comparable<City>{
    int num;
    int cost;

    public City(int num, int cost) {
        this.num = num;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(City o){
        return this.cost > o.cost ? 1 : -1;
    }
}
