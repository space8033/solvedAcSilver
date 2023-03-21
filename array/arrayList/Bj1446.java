package array.arrayList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj1446 {
    static ArrayList<ShortCut>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[] distance = new int[d + 1];
        list = new ArrayList[10001];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for(int i = 0; i < 10001; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int far = Integer.parseInt(st.nextToken());

            if(end - start > far) {
                list[end].add(new ShortCut(start, far));
            }
        }

        distance[0] = 0;
        for(int i = 1; i <= d; i++) {
            if(list[i].size() > 0) {
                for(ShortCut s : list[i]) {
                    if(distance[s.start] + s.far > distance[i]) {
                        continue;
                    }
                    distance[i] = Math.min(distance[i - 1] + 1, distance[s.start] + s.far);
                }

                continue;
            }

            distance[i] = distance[i - 1] + 1;
        }

        System.out.println(distance[d]);
    }
    public static class ShortCut {
        int start, far;
        public ShortCut(int start, int far) {
            this.start = start;
            this.far = far;
        }
    }
}
