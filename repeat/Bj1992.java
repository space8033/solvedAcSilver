package repeat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1992 {
    static int[][] map;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i = 0; i < n; i++) {
            String s = br.readLine();;
            for(int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        quad(0, 0, n);
        System.out.println(sb);
    }

    public static void quad(int x, int y, int size) {
        if(possible(x, y, size)) {
            sb.append(map[x][y]);
            return;
        }

        int nextSize = size / 2;
        sb.append('(');

        quad(x, y, nextSize);
        quad(x, y + nextSize, nextSize);
        quad(x + nextSize, y, nextSize);
        quad(x + nextSize, y + nextSize, nextSize);

        sb.append(')');
    }

    public static boolean possible(int x, int y, int size) {
        int value = map[x][y];

        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                if(value != map[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
