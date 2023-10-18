package D3;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1234_비밀번호 {
    static ArrayList<String> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int t = 1; t <= 10; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new ArrayList<>();
            int length = Integer.parseInt(st.nextToken());
            String[] nums = st.nextToken().split("");
            for (int i = 0; i < length; i++) {
                arr.add(nums[i]);
            }
            //삭제
            int left = 0;
            while (left < arr.size()-1) {
                if (arr.get(left).equals(arr.get(left+1))) {
                    arr.remove(left);
                    arr.remove(left);
                    left--;
                    if(left < 0)
                        left = 0; //인덱스 범위
                } else {
                    left++;
                }
            }
            //끝난 후 출력
            bw.write("#" + t + " ");
            for (int i = 0; i < arr.size(); i++) {
                bw.write(arr.get(i));
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
