package 배열과_리스트;
import java.util.Scanner;

public class P11720_숫자의합{
    public void out(){
        Scanner sc = new Scanner(System.in);
        //1. 처음 입력 받는 수 = N
        int N = sc.nextInt();
        //2. 입력 숫자들을 문자열에 저장
        String sNum = sc.next();
        //3. 문자열 -> char[]에 쪼개서 저장 => .toCharArray()
        char[] cNum = sNum.toCharArray();
        //4. 하나씩 정수형 변환 후 누적합
        int sum = 0;
        for(int i = 0; i < cNum.length; i++){
            sum += cNum[i] - '0'; //정수형 변환 방법 >> - '0' <<
        }
        System.out.println(sum);
    }
}