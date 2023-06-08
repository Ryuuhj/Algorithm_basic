package 버블정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class P1377_버블소트1{
    public static void out() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        mData[] A = new mData[N];
        
        for(int i=0; i<N; i++){
            A[i] = new mData(Integer.parseInt(br.readLine()), i);
        }
        Arrays.sort(A);

        int max = 0;
        for(int j=0;j<N;j++){
            if(max < (A[j].index - j)){
                max = A[j].index - j;
            }
        }
        System.out.println(max+1); //마지막에 +1
        
    }
}

class mData implements Comparable<mData>{
    int value;
    int index;

    public mData(int value, int index){
        super();
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(mData o){ //value 기준 오름차순 정렬
        return this.value - o.value;
    }
}
