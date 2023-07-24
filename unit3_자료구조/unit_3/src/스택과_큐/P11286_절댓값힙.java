package 스택과_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.lang.Math;

public class P11286_절댓값힙 {
    public static void out() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //정렬 조건 직접 지정 해 우선순위 큐 사용 가능
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> { 
            int firstAbs = Math.abs(o1);
            int secondAbs = Math.abs(o2);
            //절댓값이 같은 경우 음수 우선
            if(firstAbs == secondAbs){
                //o2가 더 작은 경우 양수 리턴 아니면 음수
                return (o1 > o2 ? 1 : -1);
            }
            //절댓값이 같은 경우 작은 데이터 우선
            else{
                //o2가 더 작은 경우 양수 리턴, o1이 더 작으면 음수 리턴
                return firstAbs - secondAbs; 
            }
        });

        for(int i=0;i<N;i++){
            int request = Integer.parseInt(br.readLine());
            if(request==0){
                if(priorityQueue.isEmpty()) {System.out.println("0");}
                else System.out.println(priorityQueue.poll());
            }
            else{
                priorityQueue.add(request);
            }
        }
    }      
}
