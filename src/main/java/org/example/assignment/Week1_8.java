package org.example.assignment;

import java.util.Scanner;

public class Week1_8 {
    public static void main(String[] args) {
        long max = Long.MAX_VALUE;
        Long[] tax1 = {
                12_000_000L,
                46_000_000L,
                88_000_000L,
                150_000_000L,
                300_000_000L,
                500_000_000L,
                1_000_000_000L,
                max
        };

        Long[] tax2 = {
                12_000_000L,
                34_000_000L,
                42_000_000L,
                62_000_000L,
                150_000_000L,
                200_000_000L,
                500_000_000L,
                max // 7
        };
        
        int[] tax3 = {
                1,
                1_080_000,
                5_220_000,
                14_900_000,
                19_400_000,
                25_400_000,
                35_400_000,
                65_400_000
        };

        int[] taxRatio = {
                6, 15, 24, 35, 38, 40, 42, 45
        };

        System.out.println("[과세금액 계산 프로그램]");
        System.out.print("연소득을 입력해 주세요.:");
        Scanner scanner = new Scanner(System.in);
        long income = Long.parseLong(scanner.nextLine());

        double flatTax = 0;
        double progressiveTax = 0;

        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            if (income > tax1[i]) {
                cnt++;
            }
        }

        if (cnt == 0) {
            flatTax = income * 0.06;
            progressiveTax = flatTax;
            System.out.printf("%10d * %d%% = \t\t\t%10.0f\n", income, 6, income * 0.06);
        } else {
        int idx = 0;
        for (int i = 0; i < cnt; i++) {
            flatTax += (long) (tax2[i] * (taxRatio[i] * 0.01));
            System.out.printf("%10d * %d%% = \t\t\t%10d\n", tax2[i], taxRatio[i], (int) (tax2[i] * (taxRatio[i] * 0.01)));
            idx = i;
        }

        long rest = income - tax1[idx];


        flatTax += (int) (rest * (taxRatio[idx + 1] * 0.01));
        System.out.printf("%10d * %d%% = \t\t\t%10d\n", rest, taxRatio[idx + 1], (int) (rest * (taxRatio[idx + 1] * 0.01)));
        progressiveTax = income * (taxRatio[cnt] * 0.01) - tax3[cnt];
        }


        System.out.printf("\n[세율에 의한 세금]:\t\t\t\t\t%8d\n", (long) flatTax);
        System.out.printf("[누직공제 계산에 의한 세금]: \t\t\t%8d", (long) progressiveTax);
    }
}
