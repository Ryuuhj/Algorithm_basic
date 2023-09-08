import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class P3003_체스말 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] pieces = {1, 1, 2, 2, 2, 8};

        int having;
        for (int i = 0; i < 6; i++) {
            having = sc.nextInt();
            bw.write(pieces[i] - having + " ");
        }
        bw.close();
    }
}
