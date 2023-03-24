package slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int min = Integer.MAX_VALUE;

        int aCount = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a') {
                aCount++;
            }
        }

        for(int i = 0; i < s.length(); i++) {
            int bCount = 0;
            for(int j = i; j < i + aCount; j++) {
                int index = j % s.length();
                if(s.charAt(index) == 'b') {
                    bCount++;
                }
            }

            min = Math.min(min, bCount);
        }

        System.out.println(min);
    }
}
