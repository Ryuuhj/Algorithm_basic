package 유클리드_호제법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//재료 노드 정의
class INode {
    int nodeNum; //본인 노드 번호
    int ratio; //본인 비
    int pairRatio; //페어 비

    public int getPair() {
        return nodeNum;
    }

    public int getRatio() {
        return ratio;
    }

    public int getPairRatio() {
        return pairRatio;
    }

    public INode(int b, int p, int q){
        super();
        this.nodeNum = b;
        this.ratio = p;
        this.pairRatio = q;
    }  
}

public class P1033_칵테일 {
    static ArrayList<INode>[] adjLists;
    static long lcm; //최소공배수
    static boolean[] visited;
    static long[] nodeValue;//노드 값 

    public static void out() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        //변수 초기화
        adjLists = new ArrayList[N];
        visited = new boolean[N];
        nodeValue = new long[N];
        lcm = 1;
        //인접리스트 초기화
        for(int i=0; i<N; i++){
            adjLists[i] = new ArrayList<INode>();
        }
        //재료, 비율 인접리스트에 저장 & 최소 공배수 갱신
        for(int i=0; i<N-1; i++){ //레시피 n-1개
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            adjLists[a].add(new INode(b, q, p));
            adjLists[b].add(new INode(a, p, q));
            //최소 공배수 갱신
            lcm *= (p*q)/gcd(p, q);
        }
        
        nodeValue[0] = lcm;
        dfs(0);

        //최대 공약수 구하기
        long gcdValue = nodeValue[0];
        for(long k : nodeValue){
            gcdValue = gcd(gcdValue, k);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(long n : nodeValue){
            stringBuilder.append(n/gcdValue+" ");
        }
        
        System.out.println(stringBuilder);

        
    }

    private static void dfs(int n) {
        visited[n] = true;
        for(INode node : adjLists[n]){ //n의 페어노드 탐색
            int next = node.nodeNum;
            if(!visited[next]){ //방문 하지 않은 페어노드 한정
                //노드 값 갱신 = 현재노드 * me/pair
                nodeValue[next] = nodeValue[n] * node.ratio/node.pairRatio;
                dfs(next);
            }
        }
    }

    private static long gcd(long p, long q) {
        long a = Math.max(p, q);
        long b = Math.min(p, q);

        if(b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
}

