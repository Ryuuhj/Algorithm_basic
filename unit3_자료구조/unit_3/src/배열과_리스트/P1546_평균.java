package 배열과_리스트;
import java.util.Scanner;

public class P1546_평균 {
    public static void out(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] numbers = new int[N];
        long max = 0;
        long sum = 0;
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = sc.nextInt();
            if(numbers[i] > max) { max = numbers[i];}
            sum += numbers[i];
            //System.out.println(max);
        }
    
        System.out.println(sum*100.0/max/N);
    }
}