package integer;

import java.util.Scanner;

public class Bj1064 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Pair[] arr = new Pair[3];
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        double[] length = new double[3];
        for(int i = 0; i < 3; i++) {
            arr[i] = new Pair(sc.nextInt(), sc.nextInt());
        }

        if((arr[1].y - arr[0].y) * (arr[2].x - arr[1].x) == (arr[1].x - arr[0].x) * (arr[2].y - arr[1].y)) {
            System.out.println("-1");

        } else {
            double first = Math.sqrt(Math.pow(arr[1].y - arr[0].y, 2) + Math.pow(arr[1].x - arr[0].x, 2));
            double second = Math.sqrt(Math.pow(arr[2].y - arr[0].y, 2) + Math.pow(arr[2].x - arr[0].x, 2));
            double third = Math.sqrt(Math.pow(arr[2].y - arr[1].y, 2) + Math.pow(arr[2].x - arr[1].x, 2));

            length[0] = first + second;
            length[1] = second + third;
            length[2] = first + third;

            for(int i = 0; i < 3; i++) {
                if(min > length[i]) {
                    min = length[i];
                }
                if (max < length[i]) {
                    max = length[i];
                }
            }
            System.out.println(2 * max - 2 * min);
        }

    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y= y;
        }
    }
}
