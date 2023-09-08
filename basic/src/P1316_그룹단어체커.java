import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1316_그룹단어체커 {
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int cnt = 0;

        while (N-- > 0) {
            //단어마다 방문 배열 초기화
            visited = new boolean[26];
            char[] word = bf.readLine().toCharArray();
            visited[(int)word[0] - 97] = true;
            boolean gWord = true;
            for (int i = 1; i < word.length; i++) {
                int idx = (int) word[i] - 97;
                if (visited[idx]) {
                    if (word[i - 1] != word[i]) { //연속하지 않으면서 방문한 경우면 아예 탈락
                        gWord = false;
                        break;
                    }
                } else {
                    visited[idx] = true;
                }
            }
            if(gWord) cnt++; //규칙 지켜진 경우에만 +1
        }
        System.out.println(cnt);
    }
}
