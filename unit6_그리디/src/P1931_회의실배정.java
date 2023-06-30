import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P1931_회의실배정 {
    static int N;

    public static void out() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(bf.readLine());

        int[][] room = new int[N][2];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            room[i][0] = Integer.parseInt(st.nextToken());
            room[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(room, new Comparator<int[]>(){ //Comparator 오버라이딩
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[1]==o2[1]){
                    return o1[0] - o2[0];
                }else{
                    return o1[1] - o2[1];
                }
            }
        });

        int end = 0;
        int cnt = 0;
        for(int[] time : room){
            if(end <= time[0]){ //이전 종료 시간 <= 현재 회의 시작 시간
                end = time[1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
