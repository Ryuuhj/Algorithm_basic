
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1715_카드정렬 {

    public static void out() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        int N = Integer.parseInt(bf.readLine());

        int cnt = 0;

        for(int i=0;i<N;i++){
            pQueue.add(Integer.parseInt(bf.readLine()));
        }

        int c1, c2 =0;
        while(pQueue.size() != 1){
            
            c1 = pQueue.poll();
            c2 = pQueue.poll();
            pQueue.add(c1+c2);
            cnt += (c1+c2);
        }
        System.out.println(cnt);
        
    }
    
}
