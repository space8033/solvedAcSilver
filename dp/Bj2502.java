package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2502 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[31];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i < 31; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        int a, b;
        a = 1;
        while (true) {
            if((k - dp[d - 3] * a) % dp[d - 2] == 0) {
                b = (k - dp[d - 3] * a) / dp[d - 2];
                break;
            }else {
                a++;
            }
        }

        System.out.println(a);
        System.out.println(b);

    }
}
