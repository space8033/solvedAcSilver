package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringTokenizer st0 = new StringTokenizer(s, "1");
        StringTokenizer st1 = new StringTokenizer(s, "0");

        System.out.println(Math.min(st1.countTokens(), st0.countTokens()));
    }
}
