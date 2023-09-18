package 정렬;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class P1431_시리얼번호 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Node> queue = new PriorityQueue<Node>();

        for (int i = 0; i < N; i++) {
            queue.add(new Node(br.readLine().toCharArray()));
        }
        while (!queue.isEmpty()) {
            bw.write(String.valueOf(queue.poll().input)+"\n");
        }
        bw.flush();
        bw.close();
    }

    private static class Node implements Comparable<Node> {
        char[] input;
        int length;
        int sum;

        public Node(char[] input) {
            this.input = input;
            this.length = input.length;
            this.sum = getSum(input);
        }

        @Override
        public int compareTo(Node node) {
            if (this.length > node.length) {
                return 1;
            } else if (this.length < node.length) {
                return -1;
            } else {
                if (this.sum > node.sum) {
                    return 1;
                } else if (this.sum < node.sum) {
                    return -1;
                } else {
                    for (int i = 0; i < this.length; i++) {
                        if ((int) this.input[i] > (int) node.input[i]) {
                            return 1;
                        }else if((int) this.input[i] < (int) node.input[i]){
                            return -1;
                        }
                    }
                }
            }
            return -1;
        }
    }

    private static int getSum(char[] s) {
        int sum = 0;
        for (char c : s) {
            if (Character.isDigit(c)) {
                sum += (int)(c - '0');
            }
        }
        return sum;
    }
}
