package queue.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Bj1276 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            pq.add(new Pair(x1, x2, y));
        }

        int answer = 0;

        int maxList[] = new int[10001];

        while (!pq.isEmpty()) {
            Pair current = pq.poll();

            answer += current.y - maxList[current.x1];
            answer += current.y - maxList[current.x2 - 1];

            for(int i = current.x1; i < current.x2; i++) {
                maxList[i] = current.y;
            }
        }

        System.out.println(answer);
    }

    static class Pair implements Comparable<Pair> {
        int x1, x2, y;

        public Pair(int x1, int x2, int y) {
            this.x1 = x1;
            this.x2 = x2;
            this.y = y;
        }

        @Override
        public int compareTo(Pair pair) {
            return this.y - pair.y;
        }
    }
}
