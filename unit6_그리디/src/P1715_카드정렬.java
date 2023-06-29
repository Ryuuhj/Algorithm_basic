import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P1715_카드정렬 {

    public static void out() {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        int N = sc.nextInt();

        Long cnt = 0L;

        for(int i=0;i<N;i++){
            pQueue.add(sc.nextInt());
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
