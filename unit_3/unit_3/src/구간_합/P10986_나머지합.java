package 구간_합;

import java.util.Scanner;


public class P10986_나머지합 {
    static Scanner sc;
    static int n, m;
    static long Sum[];
    static long Rcount[];
    static long cnt;
    public void out(){
        sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        Sum = new long[n];
        Rcount = new long[m];
        
        Sum[0] = sc.nextInt();
        for(int i=1; i<n; i++){
            Sum[i] = Sum[i-1] + sc.nextInt();
        }

        int remainder;
        for(int j = 0; j<n; j++){
            remainder = (int) Sum[j] % m;
            Rcount[remainder]++;
            if(remainder==0){
                cnt++;
            }
        }

        for(int q=0; q<Rcount.length;q++){
            long k = Rcount[q];
            if(k>1) cnt += k*(k-1)/2;
        }

        System.out.println(cnt);
    }
}
