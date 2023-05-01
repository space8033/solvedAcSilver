package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2564 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(br.readLine());

        int count = 0;
        int police = 0;
        int[] distance = new int[l];
        for(int i = 0; i < l + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int direction = Integer.parseInt(st.nextToken());
            int location = Integer.parseInt(st.nextToken());
            int temp = 0;

            if(direction == 1) {
                temp = location;
            }else if(direction == 2) {
                temp = n + m + n - location;
            }else if(direction == 3) {
                temp = n + m + n + m - location;
            }else if(direction == 4) {
                temp = n + location;
            }

            if(i < l) {
                distance[i] = temp;
            }else  {
                police = temp;
            }
        }

        for(int i = 0; i < l; i++) {
            int path1 = Math.abs(police - distance[i]);
            int path2 = 2 * n + 2 * m -path1;

            count += Math.min(path1, path2);
        }

        System.out.println(count);
    }
}
