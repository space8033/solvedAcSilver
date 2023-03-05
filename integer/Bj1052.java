package integer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int answer = 0;

        while (true) {
            char[] arr = Integer.toBinaryString(n).toCharArray();
            int count = 0;

            for(int i = 0; i < arr.length; i++) {
                if(arr[i] == '1') {
                    count++;
                }
            }

            if(count <= k) {
                System.out.println(answer);
                break;
            }

            n++;
            answer++;
        }
    }
}
