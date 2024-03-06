package org.example.assignment;

import java.util.Scanner;

public class Week1_2 {
    public static void main(String[] args) {
        System.out.println("[캐시백 계산]");
        System.out.print("결제 금액을 입력해 주세요. (금액):");
        Scanner scanner = new Scanner(System.in);
        int payment = Integer.parseInt(scanner.next());
        int payback = payment / 10 / 100 * 100;

        if (payback > 300) {
            payback = 300;
        }
        System.out.printf("결제 금액은 %d원이고, 캐시백은 %d원 입니다.", payment, payback);

    }
}
