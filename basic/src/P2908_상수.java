import java.util.Scanner;

public class P2908_상수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] nums = input.split(" "); //공백 기준 2개로 나눠짐
        int A = reverseInt(nums[0]);
        int B = reverseInt(nums[1]);
        System.out.println(Math.max(A, B));
    }

    private static int reverseInt(String num) {
        //charAt은 char 반환하므로 아스키코드 변환 해줘야 함 -> "String" Array로
        String[] n = num.split("");
        return Integer.parseInt(n[2] + n[1] + n[0]);
    }
}
