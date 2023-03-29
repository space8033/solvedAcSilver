package integer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1629 {
    public static long c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());


        System.out.println(rest(a, b));
    }

    public static long rest(long a, long exponent) {
        if(exponent == 1) {
            return a % c;
        }

        long temp = rest(a, exponent / 2);

        if(exponent % 2 == 1) {
            return (temp * temp % c) * a % c;
        }

        return temp * temp % c;
    }
}
