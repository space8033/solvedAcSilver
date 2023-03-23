package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Bj1495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[m + 1];
        for(int i = 0; i < m + 1; i++) {
            arr[i] = -1;
        }
        arr[s] = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            int volume = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();

            for(int j = 0; j <= m; j++) {
                if(arr[j] == i) {
                    int plus = j + volume;
                    int minus = j - volume;

                    if(plus <= m) {
                        list.add(plus);
                    }
                    if(minus >= 0) {
                        list.add(minus);
                    }
                }
            }

            for(int possible : list) {
                arr[possible] = i + 1;
            }
        }

        int max = -1;

        for(int i = 0; i <= m; i++) {
            if(arr[i] == n) {
                max = Math.max(max, i);
            }
        }

        System.out.println(max);
    }
}
