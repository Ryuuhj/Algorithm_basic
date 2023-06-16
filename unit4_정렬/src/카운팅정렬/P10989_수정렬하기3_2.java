package 카운팅정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P10989_수정렬하기3_2 {
    public static int cnt[];
    public static void out() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //BufferedWriter 사용 버전
        StringBuilder sb = new StringBuilder(); //StringBuilder 사용 버전
        int N = Integer.parseInt(br.readLine());

        cnt = new int[10001];
        for(int i=0; i<N; i++){
            cnt[Integer.parseInt(br.readLine())]++;
        }
        br.close();

        for(int i=1;i<cnt.length;i++){
            while(cnt[i]>0){
                //bw.write(i+"\n");
                sb.append(i).append("\n");
                cnt[i]--;
            }   
        }
        // bw.flush();
        // bw.close();
        System.out.println(sb.toString());
        
    }
}
