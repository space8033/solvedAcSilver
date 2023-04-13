package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1932 {
    static int n;
    static int[][] triangle;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        triangle = new int[n][n];

        StringTokenizer st;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < i + 1; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            dp[n - 1][i] = triangle[n - 1][i];
        }

        System.out.println(find(0, 0));

    }

    static int find(int depth, int index) {
        if(depth == n - 1) {
            return dp[depth][index];
        }

        if(dp[depth][index] == 0) {
            dp[depth][index] = Math.max(find(depth + 1, index), find(depth + 1, index + 1)) + triangle[depth][index];
        }

        return dp[depth][index];
    }
}
