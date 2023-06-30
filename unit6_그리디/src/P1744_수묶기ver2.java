import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class P1744_수묶기ver2 {
    static int N;
    public static void out() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        //우선순위 큐는 내림차순 정렬 꼭! 해야 함~~
        PriorityQueue<Integer> pos = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> neg = new PriorityQueue<>();
        int one=0, zero=0, sum = 0;
        
        int k;
        for(int i=0; i<N; i++){
            k = Integer.parseInt(bf.readLine());
            if(k>1) pos.add(k);
            else if(k==1) one++;
            else if(k==0) zero++;
            else neg.add(k);
        }

        //int e1=0, e2 =0;
        sum+= one;

        while(!pos.isEmpty()){
            if(pos.size()==1){
                sum += pos.poll();
                break;
            }
            int e1 = pos.poll();
            int e2 = pos.poll();
            sum += e1*e2;
        }
        //System.out.println("pos끝>"+sum);

        while(!neg.isEmpty()){
            if(neg.size()==1){
                if(zero>0) break;
                else{
                    sum += neg.poll();
                    break;}
            }
            int e1 = neg.poll();
            int e2 = neg.poll();
            //System.out.println("neg>>"+e1+"e2>"+e2);
            sum += e1*e2;
        }
        System.out.println(sum);
    }
}
