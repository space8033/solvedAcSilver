package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Bj2583 {
    static int m, n, k;
    static int[][] map;
    static int[] dirR = {-1, 1, 0 ,0};
    static int[] dirC = {0, 0, -1 ,1};
    static int count = 0;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[m][n];

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int j = x1;j < x2; j++) {
                for(int k = y1; k < y2; k++) {
                    map[k][j] = 1;
                }
            }
        }

        list = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 0) {
                    count = 0;
                    dfs(i, j);
                    list.add(count);
                }
            }
        }

        System.out.println(list.size());
        Collections.sort(list);

        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    public static void dfs(int r, int c) {
        map[r][c] = 1;
        count++;

        for(int i = 0; i < 4; i++) {
            int nextR = r + dirR[i];
            int nextC = c + dirC[i];

            if(nextR >= 0 && nextC >= 0 && nextR < m && nextC < n) {
                if(map[nextR][nextC] == 0) {
                    dfs(nextR, nextC);
                }
            }
        }
    }
}
