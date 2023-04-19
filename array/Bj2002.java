package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Bj2002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        int count = 0;

        for(int i = 0; i < n; i++) {
            map.put(br.readLine(), i);
        }

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = map.get(br.readLine());
        }

        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                if(arr[i] > arr[j]) {
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
