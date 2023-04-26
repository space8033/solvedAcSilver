package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bj2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Stack<Character> stack = new Stack<>();
        boolean opened = true;
        int answer = 0;
        int count = 1;

        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            if (now == '(') {
                stack.push(now);
                count *= 2;
            } else if (now == '[') {
                stack.push(now);
                count *= 3;
            } else {
                if (now == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        opened = false;
                        break;
                    }
                    if (s.charAt(i - 1) == '(') {
                        answer += count;
                    }
                    stack.pop();
                    count /= 2;
                } else if (now == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        opened = false;
                        break;
                    }
                    if (s.charAt(i - 1) == '[') {
                        answer += count;
                    }
                    stack.pop();
                    count /= 3;
                } else {
                    opened = false;
                    break;
                }
            }
        }

        if (!opened || !stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }
}
