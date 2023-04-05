package integer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1850 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long n = gcd(a, b);

        if(n == 1) {
            System.out.println(1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for(long i = 0; i < n; i++) {
            sb.append("1");
        }

        System.out.println(sb.toString());
    }

    public static long gcd(long x, long y) {
        if(x < y) {
            long temp = x;
            x = y;
            y = temp;
        }

        while (y != 0) {
            long r = x % y;
            x = y;
            y = r;
        }

        return x;
    }
}
