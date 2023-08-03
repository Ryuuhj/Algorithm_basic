package 이진_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1991_트리순회 {
    static int n;
    static int[][] tree;
    static StringBuilder preA, inA, postA;
    static char[] chars;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        tree = new int[n][2];
        chars = new char[n];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (65 + i);
        }

        //트리에 노드들 저장
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            int now = st.nextToken().charAt(0) - 'A';
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            if (left == '.') {
                tree[now][0] = -1;
            } else {
                tree[now][0] = left - 'A';
            }
            if (right == '.') {
                tree[now][1] = -1;
            } else {
                tree[now][1] = right - 'A';
            }
        }
        preA = new StringBuilder();
        inA = new StringBuilder();
        postA = new StringBuilder();

        //저장한 노드 바탕으로 전위-중위-후위 순회 후 결과 차례로 출력

        preOrder(0); //root = A = 0
        inOrder(0);
        postOrder(0);
        System.out.println(preA + "\n" + inA + "\n" + postA);

    }

    private static void postOrder(int now) { //후위 : 왼 - 오 - 중
        if(now == -1) return;
        //왼쪽
        postOrder(tree[now][0]);
        //오른쪽
        postOrder(tree[now][1]);
        //중앙
        postA.append(chars[now]);
    }

    private static void inOrder(int now) { //중위 : 왼쪽 - 중앙 - 오른쪽
        if(now == -1) return;
        //왼쪽
        inOrder(tree[now][0]);
        //중앙
        inA.append(chars[now]);
        //오른쪽
        inOrder(tree[now][1]);
    }

    private static void preOrder(int now) { //전위 : 중앙 - 왼쪽 - 오른쪽 순서
        if (now == -1) return;
        //중앙
        preA.append(chars[now]);
        //왼쪽
        preOrder(tree[now][0]);
        //오른쪽
        preOrder(tree[now][1]);
    }
}
