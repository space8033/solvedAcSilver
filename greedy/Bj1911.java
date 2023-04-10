package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj1911 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[][] road = new int[n][2];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            road[i][0] = Integer.parseInt(st.nextToken());
            road[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(road, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }else {
                return o1[0] - o2[0];
            }
        });

        int count = 0;
        int board = 0;

        for(int i = 0; i < road.length; i++) {
            if(road[i][0] > board) {
                board = road[i][0];
            }

            if(road[i][1] > board) {
                while (road[i][1] > board) {
                    board += l;
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
