package integer;

import java.util.Scanner;

public class Bj1094 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int answer = 0;
        int[] lengths = new int[] {64, 32, 16, 8, 4, 2, 1};

        while (x > 0) {
            for(int i = 0; i < lengths.length; i++) {
                if(x >= lengths[i]) {
                    x -= lengths[i];
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
