package org.example.assignment;

import java.util.Scanner;

public class Week1_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fee = 10000;
        boolean free = false;
        boolean special = false;
        boolean normal = false;

        System.out.println("[입장권 계산]");
        System.out.print("나이를 입력해 주세요.(숫자):");
        int age = Integer.parseInt(scanner.nextLine());
        if (age < 3) {
            free = true;
        }
        if (age < 13) {
            special = true;
        }

        System.out.print("입장시간를 입력해 주세요.(숫자입력):");
        int time = Integer.parseInt(scanner.nextLine());
        if (time > 17) {
            special = true;
        }

        System.out.print("국가유공자 여부를 입력해 주세요.(y/n):");
        String war = scanner.nextLine();
        if (war.equals("y")) {
            normal = true;
        }

        System.out.print("복지카드 여부를 입력해 주세요.(y/n):");
        String card = scanner.nextLine();
        if (card.equals("y")) {
            normal = true;
        }

        if (normal) {
            fee = 8000;
        }

        if (special) {
            fee = 8000;
        }

        if (free) {
            fee = 4000;
        }

        System.out.println(fee);
    }
}
