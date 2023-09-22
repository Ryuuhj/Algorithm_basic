package 집합과_맵;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P1620_포켓몬_마스터 {
    static String input;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<Integer, String> pokemon = new HashMap<Integer, String>();
        HashMap<String, Integer> Rpokemon = new HashMap<String, Integer>();

        for (int i = 1; i <= N; i++) {
            input = br.readLine();
            if (!pokemon.containsKey(i)) {
                pokemon.put(i, input);
                Rpokemon.put(input, i);
            }

        }

        for (int i = 0; i < M ; i++) {
            input = br.readLine();
            if (Character.isDigit(input.charAt(0))) {
                bw.write(pokemon.get(Integer.parseInt(input)) + "\n");
            } else {
                bw.write(Rpokemon.get(input) + "\n");
            }
        }
        bw.close();

    }


}
