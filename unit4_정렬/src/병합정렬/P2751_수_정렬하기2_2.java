package 병합정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P2751_수_정렬하기2_2 {
    public static void out(){
        Scanner sc = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        int N = sc.nextInt();

        ArrayList<Integer> A = new ArrayList<>();

        for(int i=0;i<N;i++){
            A.add(sc.nextInt());
        }

        //Collectios.sort 사용
        Collections.sort(A);

        for(int i:A){
            stringBuilder.append(i).append("\n"); //자연스럽게 문자열
        }

        System.out.println(stringBuilder);
        
    }
}
