import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P1744_수묶기 {
    static int N;
    public static void out() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        int sum =0;

        for(int i=0; i<N; i++){
            pQueue.add(Integer.parseInt(bf.readLine()));
        }
        
        int e1, e2 = 0;
        int tmp = 0;
        while(!pQueue.isEmpty()){
            if(pQueue.size()==1){
                sum += pQueue.poll();
                break;
            }
            e1= pQueue.poll();   
            e2 = pQueue.poll();
            tmp = e1*e2;
            if(tmp > 0){
                if((e1==1)||(e2==1)){
                    if(pQueue.size()%2 == 1){ //나머지 개수 홀수
                        if(e1==1) pQueue.add(e2);
                        else pQueue.add(e1);
                        sum += 1;
                    }else{
                        sum += (e1+e2);
                    }
                }
                else{
                    if(pQueue.size()%2 == 1){
                        if(e1<0){
                            sum += tmp;
                        }else{
                            sum+= e1;
                            pQueue.add(e2);
                            System.out.println("e2>>"+e2);
                        } 
                    }else{
                        sum += tmp;
                    }
                }   
            }
            else if(tmp < 0){
                if(pQueue.size()%2 == 1){ //나머지 개수 홀수
                    //System.out.println(pQueue.size()%2);
                    if(e1<0){ //e1음수, e2 양수
                        pQueue.add(e2);
                        sum += e1;
                    }else{
                        pQueue.add(e1);
                        sum += e2;
                    }
                }else{ //나머지 개수 짝수
                    sum += (e1+e2);
                }
            }else{ //tmp == 0인 경우
                if(pQueue.size()%2 == 1){
                    if(e1 == 0){
                        if(e2<0) continue;
                        else pQueue.add(e2);
                    }else{// e2==0
                        if(e1<0) continue;
                        else pQueue.add(e1); 
                    }
                }else{
                    if(e1 == 0){
                        if(e2<0) continue;
                        else sum += e2;
                    }else{// e2==0
                        if(e1<0) continue;
                        else sum += e1;
                    }
                }
            }
        }
        System.out.println(sum);      
    }
}