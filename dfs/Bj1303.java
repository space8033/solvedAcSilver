package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1303 {
    static int n, m, nowX, nowY;
    static int count = 0;
    static int white = 0;
    static int black = 0;

    static char[][] map;
    static boolean[][] visited;

    static int[] dirY = {-1, 1, 0, 0};
    static int[] dirX = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[m][n];
        visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            String s = br.readLine();
            for(int j = 0; j < n; j++) {
                char c = s.charAt(j);
                map[i][j] = c;
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    char color = map[i][j];
                    count = 0;
                    dfs(j, i, color);

                    if(color == 'W') {
                        white += count * count;
                    }else {
                        black += count * count;
                    }
                }
            }
        }

        System.out.println(white + " " + black);
    }

    public static void dfs(int x, int y, char color) {
        visited[y][x] = true;
        count++;

        for(int i = 0; i < 4; i++) {
            nowX = x + dirX[i];
            nowY = y + dirY[i];

            if(check() && map[nowY][nowX] == color && !visited[nowY][nowX]) {
                dfs(nowX, nowY, map[nowY][nowX]);
            }
        }
    }

    public static boolean check() {
        return (0 <= nowY && nowY < m && 0 <= nowX && nowX < n);
    }
}
