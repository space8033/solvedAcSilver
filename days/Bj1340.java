package days;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1340 {
    public static void main(String[] args) throws IOException {
        String[] months = {"No", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] time = br.readLine().split(" ");
        int year = Integer.parseInt(time[2]);
        boolean checkYear = false;
        if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            checkYear = true;
        }

        int month = 0;
        for(int i = 0; i < months.length; i++) {
            if(time[0].equals(months[i])) {
                month = i;
                break;
            }
        }

        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int day = Integer.parseInt(time[1].split(",")[0]);
        int dayCount = 0;
        for(int i = 1; i < month; i++) {
            if(checkYear && i == 2) {
                dayCount += 29;
                continue;
            }
            dayCount += days[i];
        }
        dayCount += day;

        int hour = 60 * Integer.parseInt(time[3].split(":")[0]);
        int min = Integer.parseInt(time[3].split(":")[1]);
        int timeHM = hour + min;
        int timeToHour = 60 * 24 * (dayCount - 1) + timeHM;

        int totalYear = 0;
        if (checkYear) {
            totalYear = 366 * 60 * 24;
        } else {
            totalYear = 365 * 60 * 24;
        }

        System.out.println((double) ((double) timeToHour * 100 / (double) totalYear));
    }
}
