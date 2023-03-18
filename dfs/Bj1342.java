package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1342 {
    static char[] alphabet = new char[26];
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        for(int i = 0; i < str.length(); i++) {
            alphabet[str.charAt(i) - 'a']++;
        }

        dfs(0, "", str.length());

        System.out.println(answer);
    }

    public static void dfs(int index, String s, int length) {
        if(index == length) {
            answer++;
            return;
        }

        for(int i = 0; i < 26; i++) {
            if(alphabet[i] == 0) {
                continue;
            }
            if(s != "" && s.charAt(s.length() - 1)  - 'a' == i) {
                continue;
            }
            alphabet[i]--;
            dfs(index + 1, s + (char)('a' + i), length);
            alphabet[i]++;
        }
    }
}
