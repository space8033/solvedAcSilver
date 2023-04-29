package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Bj2529 {
    static int k;
    static char[] c = new char[10];
    static boolean[] visited = new boolean[10];
    static ArrayList answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int j = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                continue;
            }

            c[j] = s.charAt(i);
            j++;
        }

        make(0, "");
        Collections.sort(answer);

        System.out.println(answer.get(answer.size() - 1));
        System.out.println(answer.get(0));
    }

    public static boolean check(char x, char y, char z) {
        if (z == '<') {
            if(x > y) {
                return false;
            }
        }else {
            if(x < y) {
                return false;

            }
        }

        return true;
    }

    public static void make(int now, String num) {
        if(now == k + 1) {
            answer.add(num);
            return;
        }

        for(int i = 0; i < 10; i++) {
            if(visited[i]) {
                continue;
            }
            if(now == 0 || check(num.charAt(now - 1), (char) (i + '0'), c[now - 1])) {
                visited[i] = true;
                make(now + 1, num + i + "");
                visited[i] = false;
            }
        }
    }
}
