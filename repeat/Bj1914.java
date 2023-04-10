package repeat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class Bj1914 {
    static ArrayList<int[]> fromTo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        fromTo = new ArrayList<>();

        BigInteger count = new BigInteger("2");

        System.out.println(count.pow(n).subtract(new BigInteger("1")));

        if(n <= 20) {
            hanoi(n, 1, 3, 2);

            for(int i = 0; i < fromTo.size(); i++) {
                System.out.println(fromTo.get(i)[0] + " " + fromTo.get(i)[1]);
            }
        }
    }

    public static void hanoi(int n, int from, int to, int mid) {
        if(n == 1) {
            fromTo.add(new int[] {from, to});
        }else {
            hanoi(n - 1, from, mid, to);
            fromTo.add(new int[] {from, to});
            hanoi(n - 1, mid, to, from);
        }
    }
}
