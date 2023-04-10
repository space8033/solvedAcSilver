package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][n + 1];

        dp[1][1] = 1;

        StringTokenizer st;
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= n; j++) {
                int move = Integer.parseInt(st.nextToken());

                if(dp[i][j] >= 1 && move != 0) {
                    if(j + move <= n) {
                        dp[i][j + move] += dp[i][j];
                    }

                    if(i + move <= n) {
                        dp[i + move][j] += dp[i][j];
                    }
                }
            }
        }
        System.out.println(dp[n][n]);
    }
}
