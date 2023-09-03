import java.util.Scanner;

public class P11758_CCW {
    static int[][] points = new int[4][2];
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 3; i++) {
            points[i][0] = sc.nextInt(); //x
            points[i][1] = sc.nextInt(); //y
        }

        int ccw = getCCW(points);

        if(ccw > 0) ans = 1;
        else if (ccw == 0) ans = 0;
        else ans = -1;

        System.out.println(ans);
    }

    private static int getCCW(int[][] points) {
        return (points[1][0] * points[2][1] + points[2][0] * points[3][1] + points[3][0] * points[1][1]) -
                (points[2][0] * points[1][1] + points[3][0] * points[2][1] + points[1][0] * points[3][1]);
    }
}
