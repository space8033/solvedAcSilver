package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1821 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        arr = new int[n];

        for(int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }

        if(f == sum(arr)) {
            for(int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            return;
        }

        while (next_permutation()) {
            if(f == sum(arr)) {
                for(int i = 0; i < arr.length; i++) {
                    System.out.print(arr[i] + " ");
                }
                return;
            }
        }
    }

    public static int sum(int[] array) {
        if(array.length == 2) {
            return array[0] + array[1];
        }

        if(array.length == 1) {
            return 1;
        }

        int[] next = new int[array.length - 1];
        int front = 0;
        int back = 1;

        while (back < array.length) {
            next[front] = array[front] + array[back];
            front++;
            back++;
        }

        return sum(next);
    }

    public static boolean next_permutation() {
        int i = arr.length - 1;

        while (i > 0 && arr[i] <= arr[i - 1]) {
            i--;
        }

        if(i <= 0) {
            return false;
        }

        int j = arr.length - 1;
        while (arr[i - 1] >= arr[j]) {
            j--;
        }

        int temp = arr[j];
        arr[j] = arr[i - 1];
        arr[i - 1] = temp;

        j = arr.length - 1;

        while (i < j) {
            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            i++;
            j--;
        }

        return true;
    }
}
