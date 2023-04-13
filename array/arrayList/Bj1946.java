package array.arrayList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Bj1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Score> list = new ArrayList<>();

            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list.add(new Score(a, b));
            }

            Collections.sort(list);

            int answer = 1;
            int min = list.get(0).b;
            for(int j = 1; j < n; j++) {
                if(list.get(j).b < min) {
                    answer++;
                    min = list.get(j).b;
                }
            }

            System.out.println(answer);
        }
    }

    public static class Score implements Comparable<Score> {
        int a, b;

        public Score(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Score o) {
            if(this.a > o.a) {
                return 1;
            }else {
                return -1;
            }
        }
    }
}
