package 트라이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14425_문자열집합 {
    static int n, m;
    static String sText, fText;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cNode root = new cNode();
        //1. 트라이 자료구조 구축
        while (n-- > 0) {
            sText = bf.readLine();
            cNode nowNode = root;
            for (int i = 0; i < sText.length(); i++) {
                int ch = sText.charAt(i) - 'a'; //아스키 코드 -> 십진수
                if (nowNode.next[ch] == null)
                    nowNode.next[ch] = new cNode();
                //다음 문자로 이동
                nowNode = nowNode.next[ch];
                if (i == sText.length() - 1) {
                    nowNode.isEnd = true;
                }
            }
        }
        //2. 입력 문자열들 검색해 일치 개수 카운팅
        int count = 0;
        while (m-- > 0) {
            fText = bf.readLine();
            cNode nowNode = root;
            for (int i = 0; i < fText.length(); i++) {
                int ch = fText.charAt(i) - 'a';
                if (nowNode.next[ch] == null) break;
                nowNode = nowNode.next[ch];
                if (i == fText.length() - 1 && nowNode.isEnd)
                    count++;
            }
        }

        System.out.println(count);
    }

    private static class cNode {
        cNode[] next = new cNode[26];
        boolean isEnd = false;
    }
}
