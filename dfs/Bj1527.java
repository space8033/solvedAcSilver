package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1527 {
    static int a, b;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        dfs(0);

        System.out.println(answer);
    }

    public static void dfs(long l) {
        if(l > b) {
            return;
        }
        if(l >= a && l <= b) {
            answer++;
        }

        dfs(l * 10 + 4);
        dfs(l * 10 + 7);
    }
}
