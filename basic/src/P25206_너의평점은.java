import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P25206_너의평점은 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = 20; //과목 개수
        double sumG = 0; //학점 총합
        double sumS = 0; //점수 총합

        while (N -- > 0) {
            String[] s = bf.readLine().split(" ");
            if (!s[2].equals("P")) { //P가 아닐 경우에만 점수 누적
                sumG += Double.parseDouble(s[1]);
                sumS += getScore(s[2]) * Double.parseDouble(s[1]);
            }
        }
        System.out.printf("%.6f%n", sumS / sumG);
    }

    private static double getScore(String input) {
        double score = 0;
        switch (input) {
            case "A+":
                score = 4.5;
                break;
            case "A0":
                score = 4.0;
                break;
            case "B+":
                score = 3.5;
                break;
            case "B0":
                score = 3.0;
                break;
            case "C+":
                score = 2.5;
                break;
            case "C0":
                score = 2.0;
                break;
            case "D+":
                score = 1.5;
                break;
            case "D0":
                score = 1.0;
                break;
            case "F":
                score = 0.0;
                break;
        }
        return score;
    }
}
