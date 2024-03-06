package org.example.assignment;

import java.util.Scanner;

public class Week1_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("[주민등록번호 계산]");
        System.out.print("출생년도를 입력해 주세요.(yyyy):");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.print("출생월을 입력해 주세요.(mm):");
        int month = Integer.parseInt(scanner.nextLine());

        System.out.print("출생일을 입력해 주세요(dd):");
        int day = Integer.parseInt(scanner.nextLine());

        System.out.print("성별을 입력해 주세요(m/f):");
        String gender = scanner.nextLine();

        int genderNumber;
        if (year < 2000) {
            if (gender.equals("m")) {
                genderNumber = 1;
            } else genderNumber = 2;
        } else {
            if (gender.equals("m")) {
                genderNumber = 3;
            } else genderNumber = 4;
        }

        int randomNumber = (int) (Math.random() * 999999) + 1;

        year %= 100;
        System.out.printf("%d%d%d-%d%d", year , month, day, genderNumber, randomNumber);

    }
}
