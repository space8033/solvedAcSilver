package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1262 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        for(int i = 0, r = r1; i < r2 - r1 + 1; i++, r++) {
            for(int j = 0, c = c1; j < c2 - c1 + 1; j++, c++) {
                int x = r % (2 * n - 1);
                int y = c % (2 * n - 1);

                int distance = Math.abs(n - 1 - x) + Math.abs(n - 1 - y);

                if(distance > n - 1) {
                    System.out.print(".");
                }else {
                    System.out.print(Character.toString((distance % 26) + 'a'));
                }
            }

            System.out.println();
        }
    }
}
