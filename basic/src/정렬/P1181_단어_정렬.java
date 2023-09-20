package 정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class P1181_단어_정렬 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] word = new String[N];
        for (int i = 0; i < N; i++) {
            word[i] = br.readLine();
        }

        word = Arrays.stream(word).distinct().toArray(String[]::new);
        Arrays.sort(word, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() > o2.length()) return 1;
                else if (o1.length() < o2.length()) {
                    return -1;
                } else {
                    if (o1.compareTo(o2) > 0)
                        return 1;
                }
                return -1;
            }
        });

        Arrays.stream(word).forEach(System.out::println);
    }
}
