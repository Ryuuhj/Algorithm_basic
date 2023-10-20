package D2;

import java.util.*;

public class P1206_View {
    static int[] buildings;
    static int w;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");

            w = sc.nextInt();
            int ans = 0;
            buildings = new int[w]; //앞뒤 00 합쳐서 w

            for (int i = 0; i < buildings.length; i++) {
                buildings[i] = sc.nextInt();
            }
            for (int i = 2; i < buildings.length - 1; i++) {
                int stand = buildings[i];
                if (stand > buildings[i - 2] && stand > buildings[i - 1] && stand > buildings[i + 1] && stand > buildings[i + 2]) {
                    ans += (stand - getMax(buildings[i - 2], buildings[i - 1], buildings[i + 1], buildings[i + 2]));

                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static int getMax(int n1, int n2, int n3, int n4) {
        int tmp = Math.max(n1, n2);
        return Math.max(n4, Math.max(tmp, n3));
    }
}
