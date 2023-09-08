import java.util.Scanner;

public class P2941_크로아티아_알파벳 {
    static String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = getCnt(sc.nextLine());
        System.out.println(answer);
    }
    private static int getCnt(String token) {
        for (String c : croatia) {
            token = token.replace(c, "$");

        }
        return token.length();
    }
}
