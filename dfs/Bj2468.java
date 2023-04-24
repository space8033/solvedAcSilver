package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2468 {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] directX = {-1, 1, 0, 0};
    static int[] directY = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        int highest = 0;
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > highest) {
                    highest = map[i][j];
                }
            }
        }

        int max = 0;
        for(int i = 0; i <= highest; i++) {
            visited = new boolean[n][n];
            int count = 0;
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    if(!visited[j][k] && map[j][k] > i) {
                        count += dfs(j, k, i);
                    }
                }
            }

            max = Math.max(max, count);
        }

        System.out.println(max);
    }

    static int dfs(int x, int y, int height) {
        visited[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int nextX = x + directX[i];
            int nextY = y + directY[i];

            if(nextX < 0 || nextY < 0 || nextX > n - 1 || nextY > n - 1) {
                continue;
            }
            if(visited[nextX][nextY]) {
                continue;
            }

            if(map[nextX][nextY] > height) {
                dfs(nextX, nextY, height);
            }
        }

        return 1;
    }
}
