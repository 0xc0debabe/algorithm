package org.example;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Written by 이재환
 * Email : 0xc0de1dea@gmail.com
 */

public class Main {
    public static void main(String[] argu) throws Exception {
        Scanner in = new Scanner(System.in);

        System.out.println("[달력 출력 프로그램]");
        System.out.print("달력의 년도를 입력해주세요. (yyyy): ");

        int year = in.nextInt();

        System.out.print("달력의 월을 입력해주세요. (mm): ");

        int month = in.nextInt();

        int prevYear = month - 1 < 1 ? year - 1 : year;
        int prevMonth = month - 1 < 1 ? 12 : month - 1;

        int nxtYear = month + 1 > 12 ? year + 1 : year;
        int nxtMonth = month + 1 > 12 ? 1 : month + 1;

        System.out.println(String.format("[%d년 %02d월]\t\t\t[%d년 %02d월]\t\t\t[%d년 %02d월]", prevYear, prevMonth, year, month, nxtYear, nxtMonth));
        System.out.println("일  월  화  수  목  금  토\t일  월  화  수  목  금  토\t일  월  화  수  목  금  토");

        LocalDate calendar = LocalDate.of(year, month, 1);
        int firstDay = calendar.getDayOfWeek().getValue();
        int lastDay = calendar.lengthOfMonth();

        LocalDate prevCalendar = LocalDate.of(prevYear, prevMonth, 1);
        int prevFirstDay = prevCalendar.getDayOfWeek().getValue();
        int prevLastDay = prevCalendar.lengthOfMonth();

        LocalDate nxtCalendar = LocalDate.of(nxtYear, nxtMonth, 1);
        int nxtFirstDay = nxtCalendar.getDayOfWeek().getValue();
        int nxtLastDay = nxtCalendar.lengthOfMonth();

        int date = 1;
        int prevDate = 1;
        int nxtDate = 1;

        while (true){
            for (int i = prevDate; i <= prevLastDay; i++){
                if (prevDate == 1){
                    for (int j = 0; j < prevFirstDay % 7; j++){
                        System.out.print("    ");
                    }
                }

                System.out.printf("%02d  ", prevDate);
                prevFirstDay++;
                prevDate++;

                if (prevFirstDay % 7 == 0 || i == prevLastDay){
                    for (int j = (prevFirstDay - 1) % 7; j < 7; j++){
                        System.out.print("    ");
                    }
                    break;
                }
            }
            for (int i = date; i <= lastDay; i++){
                if (date == 1){
                    for (int j = 0; j < firstDay % 7; j++){
                        System.out.print("    ");
                    }
                }

                System.out.printf("%02d  ", date);
                firstDay++;
                date++;

                if (firstDay % 7 == 0 || i == lastDay){
                    for (int j = (firstDay - 1) % 7; j < 7; j++){
                        System.out.print("    ");
                    }
                    break;
                }
            }
            for (int i = nxtDate; i <= nxtLastDay; i++){
                if (nxtDate == 1){
                    for (int j = 0; j < nxtFirstDay % 7; j++){
                        System.out.print("    ");
                    }
                }

                System.out.printf("%02d  ", nxtDate);
                nxtFirstDay++;
                nxtDate++;

                if (nxtFirstDay % 7 == 0 || i == nxtLastDay){
                    for (int j = (nxtFirstDay - 1) % 7; j < 7; j++){
                        System.out.print("    ");
                    }
                    break;
                }
            }
            if (prevDate >= prevLastDay && date >= lastDay && nxtDate >= nxtLastDay){
                break;
            }

            System.out.println();
        }
    }
}