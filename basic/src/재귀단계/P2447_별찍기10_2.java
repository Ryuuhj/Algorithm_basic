package 재귀단계;

import java.io.*;

public class P2447_별찍기10_2 {
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        arr = new char[N][N];
        printStar(0, 0, N, false);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(arr[i][j]+"");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    private static void printStar(int x, int y, int N, boolean blank) {
        if (blank) {
            for (int i = x; i < x + N; i++) {
                for (int j = y; j < y + N; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }
        if (N == 1) {
            arr[x][y] = '*';
            return;
        }
        //다시 9분할 하는 과정
        int size = N / 3;
        int cnt = 0; //5번째 공백 체크
        for (int i = x; i < x + N; i += size) {
            for (int j = y; j < y + N; j += size) {
                cnt++;
                if(cnt == 5)
                    printStar(i, j, size, true);
                else
                    printStar(i, j, size, false);
            }
        }

    }
}
