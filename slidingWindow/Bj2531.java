package slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Bj2531 {
    static int n, d, k, c;
    static int[] sushi;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        sushi = new int[n + k - 1];
        for(int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
        for(int i = n; i < n + k - 1; i++) {
            sushi[i] = sushi[i - n];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for(int i = 0; i < k; i++) {
            map.compute(sushi[i], (k, v) -> v == null ? 1 : v + 1);
        }
        if(!map.containsKey(c)) {
            count = map.size() + 1;
        }else {
            count = map.size();
        }

        for(int i = 0; i < n - 1; i++) {
            if(map.get(sushi[i]) == 1) {
                map.remove(sushi[i]);
            }else {
                map.put(sushi[i], map.get(sushi[i]) - 1);
            }

            map.compute(sushi[i + k], (k, v) -> v == null ? 1 : v + 1);

            if(!map.containsKey(c)) {
                count = Math.max(count, map.size() + 1);
            }else {
                count = Math.max(count, map.size());
            }
        }

        System.out.println(count);
    }
}
