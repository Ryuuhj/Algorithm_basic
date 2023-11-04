package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1983_조교의_성적_매기기 {
    static final String[] grade = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
    static int N, K, gr;
    static int[] score;
    static Student[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new Student[N];
            for (int i = 1; i <= N ; i++) {
                score = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                arr[i - 1] = new Student(i,  score[0] * 0.35 + score[1] * 0.45 + score[2] * 0.2);
            }
            Arrays.sort(arr);
            for (int i = 0; i < N; i++) {
                if(arr[i].idx == K) {
                    gr = i / (N / 10);
                    break;
                }
            }
            sb.append(grade[gr]).append("\n");
        }
        System.out.println(sb);
    }

    private static class Student implements Comparable<Student> {
        int idx;
        double total;

        Student(int idx, double total) {
            this.idx = idx;
            this.total = total;
        }

        @Override
        public int compareTo(Student o) {
            if(this.total >o.total)
                return -1;
            else
                return 1;
        }
    }
}
