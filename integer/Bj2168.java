package integer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2168 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int g = gcd(x, y);

        System.out.println(x + y - g);
    }

    public static int gcd(int x, int y) {
        if(y > x) {
            int temp = x;
            x = y;
            y = temp;
        }

        while (y != 0) {
            int r = x % y;
            x = y;
            y = r;
        }

        return x;
    }
}
