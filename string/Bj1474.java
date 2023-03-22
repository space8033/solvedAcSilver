package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1474 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] arr = new String[n];

        int total = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
            total += arr[i].length();
        }

        int count = m - total;
        int base = count / (n - 1);
        int spare = count % (n - 1);
        int noSpare = n - 1 - (count % (n - 1));

        for(int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i]);

            for(int j = 0; j < base; j++) {
                System.out.print('_');
            }

            if(arr[i + 1].charAt(0) > 95) {
                if (spare > 0) {
                    System.out.print('_');
                    spare--;
                }else {
                    noSpare--;
                }
            }else {
                if(noSpare > 0) {
                    noSpare--;
                }else {
                    System.out.print('_');
                    spare--;
                }
            }
        }

        System.out.print(arr[arr.length - 1]);
    }
}
