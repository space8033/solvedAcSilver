package array.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj1263 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] toDo = new int[n][2];
        int answer;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            toDo[i][0] = t;
            toDo[i][1] = s;
        }

        Arrays.sort(toDo, ((o1, o2) -> o2[1] - o1[1]));
        answer = toDo[0][1] - toDo[0][0];

        for(int i = 1; i < n; i++) {
            if(toDo[i][1] < answer) {
                answer = toDo[i][1];
            }
            answer -= toDo[i][0];
        }

        if(answer > 0) {
            System.out.println(answer);
        }else {
            System.out.println(-1);
        }
    }
}
