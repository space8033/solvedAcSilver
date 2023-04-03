package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj1697 {
    static int[] visited = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if(current == k) {
                System.out.println(visited[current] - 1);
                return;
            }

            if(current - 1 >= 0 && visited[current - 1] == 0) {
                visited[current - 1] = visited[current] + 1;
                queue.add(current - 1);
            }

            if(current + 1 <= 100000 && visited[current + 1] == 0) {
                visited[current + 1] = visited[current] + 1;
                queue.add(current + 1);
            }

            if(current * 2 <= 100000 && visited[current * 2] == 0) {
                visited[current * 2] = visited[current] + 1;
                queue.add(current * 2);
            }
        }
    }
}
