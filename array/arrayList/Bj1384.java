package array.arrayList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1384 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int index = 1;

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) {
                break;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("Group " + index + "\n");

            String[][] list = new String[n][n];

            for(int i = 0; i < n; i++) {
                String[] str = br.readLine().split(" ");
                list[i] = str;
            }

            int check;
            int count = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(list[i][j].equals("N")) {

                        check = i - j;
                        if(check < 0) {
                            check += n;
                        }
                        sb.append(list[check][0] + " was nasty about " + list[i][0] + "\n");
                        count++;
                    }
                }
            }

            if(count == 0) {
                sb.append("Nobody was nasty" + "\n");
            }

            System.out.println(sb);
            index++;
        }
    }
}
