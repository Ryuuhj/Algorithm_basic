package 슬라이딩_윈도우;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P11003_최솟값찾기 {
    static int N;
    static int L;
    public static void out() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        
        Deque<Node> myDeque = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int p = Integer.parseInt(st.nextToken());

            //덱이 empty 아닌 경우, p가 제일 클 때까지 last 노드 제거
            while(!myDeque.isEmpty() && (myDeque.peekLast().data > p)){
                myDeque.removeLast();
            }
            //add 먼저
            myDeque.addLast(new Node(i, p));
            //인덱스 비교
            if((i-L)>=myDeque.getFirst().idx){
                myDeque.removeFirst();
            }
            
            //덱 맨 앞 노드 값 출력 (최솟값)
            bw.write(myDeque.getFirst().data + " "); //구분용 공백 추가
        }
        //출력
        bw.flush();
        bw.close();

    }

    private static class Node{
        public int idx;
        public int data;

        Node(int idx, int data){
            this.idx = idx;
            this.data = data;
        }
    }
}
