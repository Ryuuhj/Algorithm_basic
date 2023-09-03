import java.util.Scanner;

public class P17387_선분교차2 {
    static long[][] points;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        points = new long[5][2]; //A(1) B(2) C(3) D(4)
        for (int i = 1; i < 5; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }
        long ccw1 = getCCW(1, 2, 3) * getCCW(1, 2, 4); //ABC * ABD
        long ccw2 = getCCW(3, 4, 1) * getCCW(3, 4, 2); //CDA * CDB

        boolean flag = checkCrossed(ccw1, ccw2);
        if (flag){
            System.out.println(1);
        }else {
            System.out.println(0);
        }

    }

    private static boolean checkCrossed(long ccw1, long ccw2) {
        //교차 경우 1. 두 값이 모두 0인 경우 (=겹치는 경우) -> 겹치는지 체크 후 판단
        if (ccw1 == 0 && ccw2 == 0)
            return checkOverlap();
        //교차 경우 2. 두 값이 모두 0 이하인 경우 (음수 , 0 조합인 경우 고려해 else if로 빼줌)
        else if(ccw1 <= 0 && ccw2 <=0)
            return true;
        //나머지 경우 - 교차 X
        return false;
    }

    private static boolean checkOverlap() {
        boolean overlaped = false;

        if(Math.min(points[3][0], points[4][0]) <= Math.max(points[1][0], points[2][0]) &&
                Math.min(points[1][0], points[2][0]) <= Math.max(points[3][0], points[4][0])&&
                Math.min(points[3][1], points[4][1]) <= Math.max(points[1][1], points[2][1]) &&
                Math.min(points[1][1], points[2][1]) <= Math.max(points[3][1], points[4][1]))
            overlaped = true;

        return overlaped;
    }

    private static long getCCW(int i1, int i2, int i3) {
        long result = (points[i1][0] * points[i2][1] + points[i2][0] * points[i3][1] + points[i3][0] * points[i1][1]) -
                (points[i2][0] * points[i1][1] + points[i3][0] * points[i2][1] + points[i1][0] * points[i3][1]);
        if(result > 0)
            return 1; //반시계 방향
        else if (result == 0) {
            return 0;
        }else
            return -1; //시계
    }
}
