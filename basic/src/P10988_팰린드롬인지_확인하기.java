import java.util.Scanner;

public class P10988_팰린드롬인지_확인하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] word = sc.nextLine().toCharArray();
        int front = 0;
        int back = word.length - 1;
        boolean flag = true;
        while (front < back) {
            if (word[front] != word[back]) {
                flag = false;
                break;
            }
            front++;
            back--;
        }
        System.out.println(flag ? 1 : 0);
    }
}
