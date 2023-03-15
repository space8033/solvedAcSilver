package array.arrayList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Bj1331 {
    public static int nowX, nowY, prevX, prevY;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        String start = br.readLine();
        int startX = start.charAt(0);
        int startY = start.charAt(1);
        prevX = startX;
        prevY = startY;
        list.add(start);

        for(int i = 0; i < 35; i++) {
            String s = br.readLine();
            nowX = s.charAt(0);
            nowY = s.charAt(1);

            if(list.contains(s)) {
                System.out.println("Invalid");
                return;
            }

            if((Math.abs(nowX - prevX) == 2 && Math.abs(nowY - prevY) == 1) || (Math.abs(nowX - prevX) == 1 && Math.abs(nowY - prevY) == 2)) {
            }else {
                System.out.println("Invalid");
                return;
            }

            list.add(s);
            prevX = nowX;
            prevY = nowY;
        }

        if((Math.abs(nowX - startX) == 2 && Math.abs(nowY - startY) == 1) || (Math.abs(nowX - startX) == 1 && Math.abs(nowY - startY) == 2)) {
        }else {
            System.out.println("Invalid");
            return;
        }

        System.out.println("Valid");
    }
}
