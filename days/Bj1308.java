package days;

import java.util.Scanner;

public class Bj1308 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int startYear = sc.nextInt();
        int startMonth = sc.nextInt();
        int startDay = sc.nextInt();
        int endYear = sc.nextInt();
        int endMonth = sc.nextInt();
        int endDay = sc.nextInt();

        if((endYear - startYear > 1000) ||
                (endYear - startYear == 1000 && startMonth > endMonth) ||
                (endYear - startYear == 1000 && startMonth == endMonth && endDay >= startDay)) {
            System.out.println("gg");
        }else {
            int start = findDays(startYear, startMonth, startDay);
            int end = findDays(endYear, endMonth, endDay);

            System.out.println("D-" + (end - start));
        }
    }

    static int[] monthDays(int year) {
        int[] day = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            day[1] = 29;
        }

        return day;
    }

    static int findDays(int year, int month, int day) {
        int days = 0;
        int[] date;

        for(int i = 1; i < year; i++) {
            date = monthDays(i);
            for(int j = 0; j < 12; j++) {
                days += date[j];
            }
        }

        date = monthDays(year);
        for(int i = 0; i < month - 1; i++) {
            days += date[i];
        }

        days += day;

        return days;
    }
}
