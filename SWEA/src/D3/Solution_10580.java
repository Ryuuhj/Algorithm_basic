package D3;


import java.util.*;

public class Solution_10580 {
    static int T, N, a, b, cnt;
    static ArrayList<Line> lines;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            cnt = 0;
            lines = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                a = sc.nextInt();
                b = sc.nextInt();
                lines.add(new Line(a, b));
            }
            Collections.sort(lines);
            for (int i = 0; i < N - 1; i++) {
                a = lines.get(i).end;
                for (int j = i + 1; j < N; j++) {
                    if(lines.get(j).end < a) cnt++;
                }
            }
            System.out.printf("#%d %d\n", tc, cnt);
        }
    }

    private static class Line implements Comparable<Line> {
        int start;
        int end;

        Line(int s, int e) {
            this.start = s;
            this.end = e;
        }

        @Override
        public int compareTo(Line o) {
            if(this.start > o.start) return 1;
            else
                return -1;
        }
    }
}
