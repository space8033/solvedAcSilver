package repeat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2527 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[8];

            for(int j = 0; j < 8; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            if(arr[2] < arr[4] || arr[3] < arr[5] || arr[6] < arr[0] || arr[7] < arr[1]) {
                System.out.println("d");
            }else if((arr[0] == arr[6] && arr[1] == arr[7]) || (arr[0] == arr[6] && arr[3] == arr[5])
                    || (arr[2] == arr[4] && arr[3] == arr[5]) || (arr[2] == arr[4] && arr[1] == arr[7])) {
                System.out.println("c");
            }else if(arr[2] == arr[4] || arr[3] == arr[5] || arr[6] == arr[0] || arr[7] == arr[1]) {
                System.out.println("b");
            }else {
                System.out.println("a");
            }
        }
    }
}
