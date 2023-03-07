package array.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1080 {
    static int n;
    static int m;
    static int[][] a;
    static int[][] b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n][m];
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

        b = new int[n][m];
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++) {
                b[i][j] = s.charAt(j) - '0';
            }
        }

        int count = 0;

        for(int i = 0; i < n - 2; i++) {
            for(int j = 0; j < m - 2; j++) {
                if(a[i][j] != b[i][j]) {
                    change(i, j);
                    count++;
                }
            }
        }

        boolean isSame = true;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(a[i][j] != b[i][j]) {
                    isSame = false;
                    break;
                }
            }
        }

        if(isSame) {
            System.out.println(count);
        }else {
            System.out.println(-1);
        }
    }

    public static void change(int x, int y) {
        for(int i = x; i < x + 3; i++) {
            for(int j = y; j < y + 3; j++) {
                a[i][j] = (a[i][j] + 1) % 2;
            }
        }
    }
}
