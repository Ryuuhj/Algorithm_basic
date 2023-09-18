package 정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2751_수_정렬하기2 {
    static int[] arr, tmp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        tmp = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(0, N - 1);

        for (int o : arr) {
            bw.write(o + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void mergeSort(int start, int end) {
        if (end <= start) //두 포인터가 만난 경우
            return;
        //중간점 정의 -> 나눌 기준
        int middle = (end + start) / 2;
        //중간 기준으로 두 그룹 나눠서 각각 진행
        mergeSort(start, middle);
        mergeSort(middle + 1, end);

        //정렬할 값 복사
        for (int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }
        //투 포인터로 크기 비교하며 병합
        int arrIdx = start; //본 배열 인덱스
        int idx1 = start;
        int idx2 = middle + 1;

        while (idx1 <= middle && idx2 <= end) {
            if (tmp[idx1] <= tmp[idx2]) {
                arr[arrIdx] = tmp[idx1];
                idx1++;
            } else {
                arr[arrIdx] = tmp[idx2];
                idx2++;
            }
            arrIdx++;
        }
        //각 그룹에 남은 것 뒤에 넣기
        while (idx1 <= middle) {
            arr[arrIdx] = tmp[idx1];
            arrIdx++;
            idx1++;
        }
        while (idx2 <= end) {
            arr[arrIdx] = tmp[idx2];
            arrIdx++;
            idx2++;
        }
    }
}
