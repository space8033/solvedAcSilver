package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bj1380 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int scenario = 0;

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) {
                return;
            }else {
                scenario++;
            }

            ArrayList<String> list = new ArrayList<>();

            for(int i = 0; i < n; i++) {
                list.add(br.readLine());
            }

            ArrayList<Integer> num = new ArrayList<>();
            for(int i = 0; i < n * 2 - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int girlNum = Integer.parseInt(st.nextToken());

                if(num.contains(girlNum)) {
                    num.remove((Integer) girlNum);
                }else {
                    num.add(girlNum);
                }
            }
            int result = num.get(0);
            System.out.println(scenario + " " + list.get(result - 1));
        }
    }
}
