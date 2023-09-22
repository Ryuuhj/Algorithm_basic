package 집합과_맵;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class P7785_회사에_있는_사람 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> record = new HashSet<String>();
        String[] tmp = new String[2];

        while (n-- > 0) {
            tmp = br.readLine().split(" ");
            if (tmp[1].equals("enter"))
                record.add(tmp[0]);
            else
                record.remove(tmp[0]);
        }
        //남은 set List 변환 후 정렬
        ArrayList<String> srtRecord = new ArrayList<>(record);
        Collections.sort(srtRecord, Collections.reverseOrder());

        for (String s : srtRecord) {
            bw.write(s + "\n");
        }
        bw.close();
    }
}
