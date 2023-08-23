import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2342_DDR {
    static int[][][] D;
    static String[] input;
    static int length;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        input = bf.readLine().split(" ");
        length = input.length - 1;
        D = new int[100001][5][5];
        for (int i = 0; i <= length; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(D[i][j], Integer.MAX_VALUE);
            }
        }
        arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }


        D[0][0][0] = 0;
        int next = arr[0];
        D[1][0][next] = 2;
        doDDR(1, 0, next);
        D[1][next][0] = 2;
        doDDR(1, next, 0);

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                result = Math.min(result, D[length][i][j]);
            }
        }
        System.out.println(result);

    }

    private static void doDDR(int i, int l, int r) {
        if (i == length) {
            return;
        }

        int next = arr[i];
        if (r == next) {

        }
        else {
            int addL = 0;

            if (Math.abs(l - next) % 2 == 1) {
                addL = 3;
            } else if (Math.abs(l - next) % 2 == 0) {
                addL = 4;
            } else if (l == next) {
                addL = 1;
            }
            D[i + 1][next][r] = Math.min(D[i+1][next][r], D[i][l][r] + addL);
            doDDR(i + 1, next, r);
        }
        if (l == next) {

        }
        else {
            int addR = 0;

            if (Math.abs(r - next) % 2 == 1) {
                addR = 3;
            } else if (Math.abs(r - next) % 2 == 0) {
                addR = 4;
            } else if (r == next) {
                addR = 1;
            }
            D[i + 1][l][next] = Math.min(D[i+1][l][next], D[i][l][r] + addR);
            doDDR(i + 1, l, next);
        }

    }
}
