package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj2302 {
    static int[] dp = new int[41];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        dp(n);

        int answer = 1;
        int before = 0;
        for(int i = 0; i < m; i++) {
            int vip = Integer.parseInt(br.readLine());
            answer *= dp[vip - before - 1];
            before = vip;
        }

        answer *= dp[n - before];

        System.out.println(answer);
    }

    public static void dp(int a) {
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= a; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
    }
}
