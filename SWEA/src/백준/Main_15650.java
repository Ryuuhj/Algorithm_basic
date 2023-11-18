package 백준;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_15650 {
    static int N, M;
    static ArrayList<Integer> arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new ArrayList<>();
        for (int i = 1; i <= (N-M +1); i++) {
            arr.add(i);
            dfs(i, 1);
            arr.remove(arr.size()-1);
        }
    }

    private static void dfs(int s, int cnt) {
        if (cnt == M) {
            StringBuilder sb = new StringBuilder();
            for (int n : arr) {
                sb.append(n + " ");
            }
            System.out.println(sb);
            return;
        }
        for (int i = s+1; i <= N; i++) {
            arr.add(i);
            dfs(i, cnt + 1);
            arr.remove(arr.size()-1);
        }
    }
}
