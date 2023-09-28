package 스택_큐_덱;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P24511_queuestack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int t1, t2 = 0;
        for (int i = 0; i < N; i++) {
            t1 = Integer.parseInt(st1.nextToken());
            t2 = Integer.parseInt(st2.nextToken());

            if (t1 == 0)  //큐에 해당하는 자료구조만 저장
                dq.offerLast(t2);
        }

        int M = Integer.parseInt(br.readLine());
        st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) { //기존 값 먼저 다 나온 후 삽입 원소 등장
            dq.offerFirst(Integer.parseInt(st1.nextToken()));
        }

        while (M-- > 0) {
            bw.write(dq.removeLast() + " ");
        }
        bw.close();
    }
}
