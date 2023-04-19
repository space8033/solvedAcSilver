package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj2156 {
    static int[] arr;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new Integer[n + 1];

        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        dp[1] = arr[1];

        if(n > 1) {
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(sum(n));

    }

    public static int sum(int n) {
        if(dp[n] == null) {
            dp[n] = Math.max(Math.max(sum(n - 2), sum(n - 3) + arr[n - 1]) + arr[n], sum(n - 1));
        }

        return dp[n];
    }
}
