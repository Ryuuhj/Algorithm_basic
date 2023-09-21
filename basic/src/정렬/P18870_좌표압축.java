package 정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P18870_좌표압축 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Point[] x = new Point[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            x[i] = new Point(i, Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(x, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.value > o2.value) return 1;
                return -1;
            }
        });

        compressPoints(x, N);

        Arrays.sort(x, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.idx > o2.idx) return 1;
                return -1;
            }
        });
        for (Point p : x) {
            bw.write(p.value + " ");
        }
        bw.close();

    }

    private static void compressPoints(Point[] x, int n) {
        int[] standard = Arrays.stream(x).mapToInt(o -> o.value).distinct().toArray();
        int k = 0;
        for (int i = 0; i < n; i++) {
            if(x[i].value != standard[k])
                k++;
            if (x[i].value == standard[k]) {
                x[i].value = k;
            }
        }
    }

    private static class Point{
        int idx;
        int value;

        public Point(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}
