package integer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1802 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            String s = br.readLine();

            if(s.length() == 1) {
                System.out.println("YES");
                continue;
            }

            int length = s.length();
            int index = length / 2;
            boolean stop = false;

            while (length != 0) {
                for(int j = 0; j < index; j++) {
                    if(s.charAt(j) == s.charAt(length - 1 - j)) {
                        stop = true;
                        break;
                    }
                }

                if(stop) {
                    break;
                }

                length /= 2;
                index /= 2;
            }

            if(stop) {
                System.out.println("NO");
            }else {
                System.out.println("YES");
            }
        }
    }
}
