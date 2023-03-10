package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1189 {
    static int R, C, K;
    static char[][] map;
    static boolean[][] visited;
    static int[] moveR = {1, -1, 0, 0};
    static int[] moveC = {0, 0, 1, -1};
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];

        for(int i = 0; i < R; i++) {
            String s = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        visited[R - 1][0] = true;
        dfs(R - 1, 0, 1);

        System.out.println(answer);
    }

    static void dfs(int r, int c, int k) {
        if(r == 0 && c == C - 1) {
            if(k == K) {
                answer++;
            }
        }

        for(int i = 0; i < 4; i++) {
            int nextR = r + moveR[i];
            int nextC = c + moveC[i];

            if(nextR < 0 || nextR >= R || nextC < 0 || nextC >= C) {
                continue;
            }
            if(visited[nextR][nextC] || map[nextR][nextC] == 'T') {
                continue;
            }
            visited[nextR][nextC] = true;
            dfs(nextR, nextC, k + 1);
            visited[nextR][nextC] = false;
        }
    }
}
