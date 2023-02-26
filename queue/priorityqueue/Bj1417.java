package queue.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Bj1417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        while (n > 1) {
            queue.add(Integer.parseInt(br.readLine()));
            n--;
        }

        int count = 0;
        while (!queue.isEmpty() && queue.peek() >= dasom) {
            count++;
            dasom++;
            queue.add(queue.poll() - 1);
        }

        System.out.println(count);
    }
}
