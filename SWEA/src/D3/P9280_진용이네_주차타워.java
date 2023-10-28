package D3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P9280_진용이네_주차타워 {
    static int N, M, car;
    static long revenue;
    static int[] charge, parkingSpace;
    static int[][] carInfo; //차 번호 [무게][주차된 번호]

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            charge = new int[N+1]; //주차공간 N개 단위 무게당 요금
            carInfo = new int[M + 1][M + 1]; //차량 무게 (1~M번째 차량)
            parkingSpace = new int[N+1]; //실제 주차공간
            revenue = 0;

            for (int i = 1; i <= N; i++) {
                charge[i] = Integer.parseInt(br.readLine());
            }
            for (int i = 1; i <= M; i++) {
                carInfo[i][0] = Integer.parseInt(br.readLine()); //row = 0 -> 무게
            }

            Queue<Integer> wait = new LinkedList<>(); //공간 없을 경우 대기할 차량 번호 담을 곳
            loop1:
            for (int i = 0; i < 2 * M; i++) {
                car = Integer.parseInt(br.readLine());
                if (car > 0) { //차가 들어오는 경우
                    for (int pi = 1; pi <= N; pi++) { //남은 공간 있는지 체크 -> 있으면 넣기
                        if (parkingSpace[pi] == 0) {
                            parkingSpace[pi] = car;
                            carInfo[car][1] = pi;
                            revenue += (long) charge[pi] * carInfo[car][0];
                            continue loop1;
                        }
                    }
                    //남아 있는 공간이 없는 경우 -> 대기실 추가
                    wait.add(car);
                } else { //나가는 경우
                    int out = carInfo[-car][1];
                    parkingSpace[out] = 0;

                    if (!wait.isEmpty()) { //대기 중인 차량이 있다면
                        car = wait.poll();
                        parkingSpace[out] = car;
                        carInfo[car][1] = out;
                        revenue += (long) charge[out] * carInfo[car][0];
                    }
                }
            }
            sb.append("#").append(t + 1).append(" ").append(revenue).append("\n");
        }
        System.out.println(sb);
    }
}
