package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution_7701 {
    static int N;
    static Set<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                } else if (o1.length() < o2.length()) {
                    return -1;
                } else {
                    for (int i = 0; i < o1.length(); i++) {
                        if(o1.charAt(i) < o2.charAt(i))
                            return -1;
                        else if (o1.charAt(i) > o2.charAt(i)) {
                            return 1;
                        }
                    }
                }
                return 0;
            }
        };
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T ; t++) {
            sb.append("#").append(t).append("\n");
            N = Integer.parseInt(br.readLine());
            set = new HashSet<>();
            while (N-- > 0) {
                String s = br.readLine();
                set.add(s);
            }
            List<String> list = new ArrayList<>();
            list.addAll(set);
            list.sort((o1, o2) -> {
                if (o1.length() > o2.length()) {
                    return 1;
                } else if (o1.length() < o2.length()) {
                    return -1;
                } else {
                    for (int i = 0; i < o1.length(); i++) {
                        if (o1.charAt(i) < o2.charAt(i))
                            return -1;
                        else if (o1.charAt(i) > o2.charAt(i)) {
                            return 1;
                        }
                    }
                }
                return 0;
            });
            for (String name : list) {
                sb.append(name).append("\n");
            }
        }
        System.out.print(sb);
    }
}
