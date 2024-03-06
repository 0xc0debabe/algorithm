package org.example.assignment;

import java.util.Calendar;
import java.util.Scanner;

public class Week1_5 {
    public static void main(String[] args) {
        System.out.println("[달력 출력 프로그램]");
        System.out.print("달력의 년도를 입력해 주세요.(yyyy): ");
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();

        System.out.print("달력의 월을 입력해 주세요.(mm): ");
        int month = scanner.nextInt();

        int prevMonth = month - 1;
        int prevYear = year;
        int nextMonth = month + 1;
        int nextYear = year;

        if (month == 1) {
            prevYear = year - 1;
            prevMonth = 12;
        }

        if (month == 12) {
            nextYear = year + 1;
            nextMonth = 1;
        }

        int prevStartDay = findStartDay(Calendar.getInstance(), prevYear, prevMonth);
        int prevEndDay = findEndDay(Calendar.getInstance(), prevYear, prevMonth);

        int currStartDay = findStartDay(Calendar.getInstance(), year, month);
        int currEndDay = findEndDay(Calendar.getInstance(), year, month);

        int nextStartDay = findStartDay(Calendar.getInstance(), nextYear, nextMonth);
        int nextEndDay = findEndDay(Calendar.getInstance(), nextYear, nextMonth);

        System.out.printf("[%d년 %02d월]", prevYear, prevMonth);
        tab(6);
        System.out.printf("[%d년 %02d월]", year, month);
        tab(6);
        System.out.printf("[%d년 %02d월]\n", nextYear, nextMonth);

        System.out.print("일\t월\t화\t수\t목\t금\t토");
        tab(3);
        System.out.print("일\t월\t화\t수\t목\t금\t토");
        tab(3);
        System.out.println("일\t월\t화\t수\t목\t금\t토");

        int prevTab = prevStartDay - 1; // 6
        int currTab = currStartDay - 1; // 1
        int nextTab = nextStartDay - 1; // 4

        int prevDay = 1;
        int currDay = 1;
        int nextDay = 1;

        prevDay = printCal1(prevTab, prevStartDay, prevDay);
        currDay = printCal1(currTab, currStartDay, currDay);
        nextDay = printCal1(nextTab, nextStartDay, nextDay);
        System.out.println();

        printCal2(prevDay, prevEndDay, currDay, currEndDay, nextDay, nextEndDay);
    }

    static int printCal1(int startTab, int startDay, int day) {
        tab(startTab);
        for (int i = 1; i <= 7 - startDay + 1; i++) {
            System.out.printf("%02d", day++);
            tab(1);
        }
        tab(2);
        return day;
    }

    static void printCal2(int prevDay, int prevEndDay, int currDay, int currEndDay, int nextDay, int nextEndDay) {
        while (true) {
            int idx = 1;
            for (int i = prevDay; i <= prevEndDay; i++) {
                System.out.printf("%02d", prevDay);
                tab(1);
                prevDay = i;
                idx++;

                if (idx % 7 == 0) {
                    tab(4);
                    idx = 1;
                    break;
                }
            }

            for (int i = currDay; i < currEndDay; i++) {
                System.out.printf("%02d", currDay);
                tab(1);
                currDay = i;
                idx++;

                if (idx % 7 == 0) {
                    tab(4);
                    idx = 1;
                    break;
                }
            }

            for (int i = nextDay; i < nextEndDay; i++) {
                System.out.printf("%02d", nextDay);
                tab(1);
                nextDay = i;
                idx++;

                if (idx % 7 == 0) {
                    System.out.println();
                    break;
                }
            }

            if ()
        }
    }

    static int findStartDay(Calendar start, int year, int month) {
        start.set(year, month - 1, 1);
        return start.get(Calendar.DAY_OF_WEEK);
    }

    static int findEndDay(Calendar end, int year, int month) {
        end.set(year, month - 1, 1);
        end.add(Calendar.DATE, -1);
        return end.get(Calendar.DATE);
    }

    static void tab(int num) {
        for (int i = 0; i < num; i++) {
            System.out.print("\t");
        }
    }
}
