package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_8888 {
    static int tc, N, T, P, jScore, jRank;
    static int[] score;
    static boolean[][] collect;
    static ArrayList<Applicant> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            T = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            score = new int[T];
            collect = new boolean[N][T];
            arr = new ArrayList<>();
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < T; i++) {
                    int num = Integer.parseInt(st.nextToken());
                    score[i] += num;
                    if (num == 1)
                        collect[n][i] = true;
                }
            }
            //지학이 최종 점수
            for (int i = 0; i < N; i++) {
                int tScore = 0, tCnt = 0;
                for (int j = 0; j < T; j++) {
                    if(collect[i][j]){
                        tScore += (N-score[j]);
                        tCnt++;
                    }
                }
                arr.add(new Applicant(i, tScore, tCnt));
            }
            jScore = arr.get(P-1).score;
            //등수 계산
            jRank =getRank(jRank);
            System.out.printf("#%d %d %d\n", t, jScore, jRank);
        }
    }

    private static int getRank(int r) {
        int rank = 0;
        Collections.sort(arr);
        for (int i = 0; i < N; i++) {
            Applicant n = arr.get(i);
            if (n.idx == P-1) {
                rank = i;
                break;
            }
        }
        return rank + 1;
    }

    private static class Applicant implements Comparable<Applicant> {
        int idx;
        int score;
        int pCnt;

        Applicant(int i, int s, int p) {
            this.idx = i;
            this.score = s;
            this.pCnt = p;
        }

        @Override
        public int compareTo(Applicant o) {
            if(this.score < o.score) return 1;
            else if(this.score > o.score) return -1;
            else {
                if(this.pCnt < o.pCnt) return 1;
                else if (this.pCnt > o.pCnt) return -1;
                else {
                    if (this.idx > o.idx) return 1;
                    else if (this.idx < o.idx) return -1;
                }
            }
            return 0;
        }
    }
}
