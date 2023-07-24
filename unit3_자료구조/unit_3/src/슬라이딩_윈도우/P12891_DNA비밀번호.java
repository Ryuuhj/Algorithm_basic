package 슬라이딩_윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12891_DNA비밀번호 {
    //메서드에서 사용해야 하는 맴버변수들
    static int myArr[];
    static int cond[];
    static int flag;
    
    static int S, P;
    

    public static void out() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        char input[] = new char[S];
        myArr = new int[4];
        cond = new int[4];
        flag = 0;
        int cnt = 0;

        input = bf.readLine().toCharArray();

        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<4; i++){
            cond[i] = Integer.parseInt(st.nextToken());
            if(cond[i]==0) flag++;
        }

        for(int i=0; i<P; i++){
            add(input[i]);
        }
        if(flag == 4) 
            cnt++;

        //윈도우 한 칸씩 이동
        for(int i=P; i<S; i++){
            add(input[i]);
            delete(input[i-P]);
            if(flag == 4) cnt++;
        }

        System.out.println(cnt);
        bf.close();

    }

    private static void add(char c){
        switch (c){
            case 'A':
                myArr[0]++;
                if(myArr[0] == cond[0])
                    flag++;
                break;

            case 'C':
                myArr[1]++;
                if(myArr[1] == cond[1]) {
                    flag++;}
                break;
                
            case 'G':
                myArr[2]++;
                if(myArr[2] == cond[2]) {
                    flag++;}
                break;

            case 'T':
                myArr[3]++;
                if(myArr[3] == cond[3]){
                    flag++;}
                break;

        }

    }
    private static void delete(char c){
        switch(c){
            case 'A':
                if(myArr[0] == cond[0]) flag--;
                myArr[0]--;
                break;
            case 'C':
                if(myArr[1] == cond[1]) flag--;
                myArr[1]--;
                break;
            case 'G':
                if(myArr[2] == cond[2]) flag--;
                myArr[2]--;
                break;
            case 'T':
                if(myArr[3] == cond[3]) flag--;
                myArr[3]--;
                break;
        }
    }

}
