package 정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10814_나이순_정렬 {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Member[] arr = new Member[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Member(i, st.nextToken(), st.nextToken());
        }

        Arrays.sort(arr);
        for (Member m : arr) {
            bw.write(m.age + " " + m.name + "\n");
        }
        bw.close();
    }

    private static class Member implements Comparable<Member> {
        int order;
        int age;
        String name;

        public Member(int i, String age, String name) {
            this.order = i;
            this.age = Integer.parseInt(age);
            this.name = name;
        }

        @Override
        public int compareTo(Member o) {
            if(this.age > o.age) return 1;
            else if (this.age < o.age) return -1;
            else {
                if (this.order > o.order) return 1;
            }
            return -1;
        }
    }
}
