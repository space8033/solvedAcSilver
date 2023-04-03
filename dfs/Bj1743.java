package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1743 {
    static int n, m, k, count;
    static boolean[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int answer = 0;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new boolean[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r - 1][c - 1] = true;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j] && map[i][j]) {
                    count = 0;
                    dfs(i, j);
                    answer = Math.max(answer, count);
                }
            }
        }

        System.out.println(answer);
    }

    public static void dfs(int x, int y) {
        count++;
        visited[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
                continue;
            }
            if(!visited[nextX][nextY] && map[nextX][nextY]) {
                dfs(nextX, nextY);
            }
        }
    }
}
