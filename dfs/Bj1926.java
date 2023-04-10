package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Bj1926 {
    static int[][] map;
    static boolean[][] visited;
    static int size;
    static int[][] direction = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        List<Integer> list = new ArrayList<>();
        boolean exist = false;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    exist = true;
                }
            }
        }

        if(!exist) {
            System.out.println("0");
            System.out.println("0");
            return;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                size = 0;
                if(!visited[i][j] && map[i][j] == 1) {
                    dfs(i, j);
                    list.add(size);
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        System.out.println(list.get(list.size() - 1));

    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        size++;

        for(int i = 0; i < direction.length; i++) {
            int nextX = x + direction[i][0];
            int nextY = y + direction[i][1];

            if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && !visited[nextX][nextY] && map[nextX][nextY] == 1) {
                dfs(nextX, nextY);
            }
        }
    }
}
