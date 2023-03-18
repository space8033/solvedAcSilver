package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj1325 {
    static List<Integer>[] list;
    static int n, m;
    static int[] count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];

        for(int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
        }

        count = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            bfs(i);
        }

        ArrayList<Integer> answer = new ArrayList<>();
        int max = 0;

        for(int i = 1; i <= n; i++) {
            if(count[i] > max) {
                max = count[i];
                answer.clear();
                answer.add(i);
            }else if(count[i] == max) {
                answer.add(i);
            }
        }

        for(int a : answer) {
            System.out.print(a + " ");
        }
    }

    public static void bfs(int start) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            for(int num : list[x]) {
                if(!visited[num]) {
                    queue.offer(num);
                    count[num]++;
                    visited[num] = true;
                }
            }
        }
    }
}
