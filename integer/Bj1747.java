package integer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1747 {
    static boolean[] arr = new boolean[1005001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        prime(1005001);

        while (true) {
            if(!arr[n] && palindrome(n)) {
                System.out.println(n);
                return;
            }else {
                n++;
            }
        }
    }

    public static void prime(int a) {
        if(a < 2) {
            return;
        }

        arr[0] = arr[1] = true;

        for(int i = 2; i <= Math.sqrt(a); i++) {
            if(arr[i]) {
                continue;
            }

            for(int j = i * i; j < arr.length; j += i) {
                arr[j] = true;
            }
        }
    }

    public static boolean palindrome(int a) {
        String s = String.valueOf(a);
        int length = s.length();

        for(int i = 0; i < length / 2; i++) {
            if(s.charAt(i) != s.charAt(length - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
