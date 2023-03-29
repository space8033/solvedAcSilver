package integer.fibonacci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bj1660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] fibo = new int[122];
        int[] fiboFibo = new int[122];

        fibo[1] = 1;
        fiboFibo[1] = 1;

        for(int i = 2; i < 122; i++) {
            fibo[i] = fibo[i - 1] + i;
            fiboFibo[i] = fibo[i] + fiboFibo[i - 1];
        }

        int[] check = new int[n + 1];
        Arrays.fill(check, Integer.MAX_VALUE);
        check[0] = 0;
        check[1] = 1;

        for(int i = 2 ; i <= n; i++) {
            for(int j = 1; j < 122; j++) {
                if(fiboFibo[j] > i) {
                    break;
                }
                check[i] = Math.min(check[i], check[i - fiboFibo[j]] + 1);
            }
        }

        System.out.println(check[n]);
    }
}
