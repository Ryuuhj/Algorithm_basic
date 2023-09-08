import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P1152_단어의_개수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] words = input.split(" ");

        List<String> removeVer = new ArrayList<>(Arrays.asList(words));
        removeVer.removeAll(Arrays.asList(" ",""));

        int length = removeVer.size();

        System.out.println(length);
    }
}
