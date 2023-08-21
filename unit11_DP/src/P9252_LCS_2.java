import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P9252_LCS_2 {
    static char[] str1, str2;
    static Stack<Character> stack = new Stack<Character>();
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        str1 = bf.readLine().toCharArray();
        str2 = bf.readLine().toCharArray();
        int len1 = str1.length;
        int len2 = str2.length;
        dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1[i - 1] == str2[j - 1]) { //문자가 일치하는 경우
                    dp[i][j] = dp[i - 1][j - 1] + 1; //왼쪽 대각선 수(x,y방향 문자 하나씩 진행 하기 전) +1
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); //그 전까지 일치하는 최대 부분집합 길이
                }
            }
        }
        //1. LCS 길이 출력
        System.out.println(dp[len1][len2]);
        //2. LCS 출력
        printLCS(len1, len2); //재귀 함수로 dp 배열 백트레킹 진행 -> 문자 출력
        StringBuilder lcs = new StringBuilder();
        while (!stack.empty()) {
            lcs.append(stack.pop());
        }
        System.out.println(lcs);
    }

    private static void printLCS(int y, int x) {
        //배열의 끝까지 왔을 경우 백트레킹 종료
        if (x == 0 || y == 0) {
            return;
        }
        //두 문자가 같을 경우 => LCS에 포함됨, 왼쪽 위 대각선으로 이동
        if (str1[y - 1] == str2[x - 1]) {
            stack.push(str1[y - 1]);
            printLCS(y - 1, x - 1);
        }
        //다른 경우 => 포함X, 그 전에 이미 해당 값으로 +1한 경우
        else { //해당 값이 유래된 곳으로 이동
            if(dp[y-1][x] > dp[y][x-1])
                printLCS(y - 1, x);
            else
                printLCS(y, x - 1);
        }
    }
}
