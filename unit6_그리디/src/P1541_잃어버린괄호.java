import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1541_잃어버린괄호 {
    public static void out() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split("-");
        int minSum = 0;

        for(int i=0; i<input.length; i++){
            if(i==0){
                minSum += stringToInt(input[i]);
            }else{ //배열 2번째 원소부터 계속 빼주기
                minSum -= stringToInt(input[i]);
            }
        }

        System.out.println(minSum);
    }

    private static int stringToInt(String exp) {
        String[] nums = exp.split("\\+");
        int partSum = 0;
        
        for(String number : nums){
            partSum += Integer.parseInt(number);
        }

        return partSum;    
    }
}
