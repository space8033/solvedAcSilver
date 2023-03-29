package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj1682 {
    static final String START = "12348765";
    static final int[][] CHANGE = {
            {4, 5, 6, 7, 0, 1, 2, 3},
            {3, 0, 1, 2, 7, 4, 5, 6},
            {0, 2, 6, 3, 4, 1, 5, 7},
            {7, 1, 2, 3, 4, 5, 6, 0}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] arr = new String[8];

        for(int i = 0; i < 4; i ++) {
            arr[i] = st.nextToken();
        }
        for(int i = 7; i >= 4; i--) {
            arr[i] = st.nextToken();
        }
        StringBuilder goal = new StringBuilder();
        for(int i = 0; i < 8; i++) {
            goal.append(arr[i]);
        }

        HashSet<String> set = new HashSet<>();
        Queue<Pair> queue = new ArrayDeque<>();

        queue.add(new Pair(START, 0));
        set.add(START);

        while (!queue.isEmpty()) {
            String current = queue.peek().s;
            int count = queue.poll().count;

            if(current.equals(goal.toString())) {
                System.out.println(count);
                return;
            }

            for(int i = 0; i < 4; i++) {
                String next = make(current, i);
                if(set.contains(next)) {
                    continue;
                }
                set.add(next);
                queue.add(new Pair(next, count + 1));
            }
        }
    }

    public static class Pair {
        String s;
        int count;

        public Pair(String s, int count) {
            this.s = s;
            this.count = count;
        }
    }

    public static String make(String s, int changeType) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 8; i++) {
            sb.append(s.charAt(CHANGE[changeType][i]));
        }

        return sb.toString();
    }
}
