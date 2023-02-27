package integer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1418 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i = 1; i <= n; i++) {
            int num = i;
            int max = 0;
            for(int j = 2; j <= Math.sqrt(i);) {
                if(num % j == 0) {
                    num /= j;
                    max = j;
                }else {
                    j++;
                }
            }

            if(num != 1) {
                max = num;
            }
            if(max <= k) {
                count++;
            }
        }

        System.out.println(count);

    }
}
