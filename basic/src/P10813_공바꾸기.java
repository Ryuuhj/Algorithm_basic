import java.util.Arrays;
import java.util.Scanner;

public class P10813_공바꾸기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] basket = new int[N + 1];
        Arrays.setAll(basket, idx -> idx);

        int i, j;
        while (M-- > 0) {
            i = sc.nextInt();
            j = sc.nextInt();
            swap(basket, i, j);
        }
        for (int k = 1; k <= N; k++) {
            System.out.print(basket[k] + " ");
        }
    }

    private static void swap(int[] basket, int i, int j) {
        int temp = basket[i];
        basket[i] = basket[j];
        basket[j] = temp;
    }
}
