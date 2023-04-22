package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        int left = 0;
        int right = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right += arr[i];
            left = Math.max(left, arr[i]);
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            int count = counting(n, arr, mid);

            if(count > m) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        System.out.println(left);
    }

    public static int counting(int n, int[] arr, int mid) {
        int sum = 0;
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(sum + arr[i] > mid) {
                sum = 0;
                count++;
            }
        }
        if(sum != 0) {
            count++;
        }

        return count;
    }
}
