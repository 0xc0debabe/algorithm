package org.example.assignment;

import java.util.*;
import java.util.stream.Collectors;

public class Week1_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("[로또 당첨 프로그램]\n");
        System.out.print("로또 개수를 입력해 주세요.(숫자 1 - 10):");
        int num = Integer.parseInt(scanner.nextLine());

        int alphabet;
        Map<Character, String> myLotto = new HashMap<>();
        for (int i = 0; i < num; i++) {
            alphabet = 65;
            String myNum = makeLotto();
            myLotto.put((char) (alphabet + i), myNum);
            System.out.printf("%c\t%s\n", alphabet + i, myLotto.get((char) (alphabet + i)));
        }

        System.out.println("\n[로또 발표]");
        String answerLotto = makeLotto();
        System.out.println("\t" + answerLotto + "\n");

        System.out.println("[내 로또 결과]");
        for (Map.Entry<Character, String> result : myLotto.entrySet()) {
            int correctNum = checkNumber(result.getValue(), answerLotto);
            System.out.printf("%c\t%s\t=>\t%d개 일치\n", result.getKey(), result.getValue(), correctNum);
        }
    }

    static String makeLotto() {
        Set<Integer> randLimit = new HashSet<>();
        while (randLimit.size() < 6) {
            int randBox = (int) (Math.random() * 45 + 1);
            randLimit.add(randBox);
        }

        List<Integer> sortNumber = new ArrayList<>(randLimit);
        Collections.sort(sortNumber);

        return sortNumber.stream()
                .map(num -> String.format("%02d", num))
                .collect(Collectors.joining(", "));
    }

    static int checkNumber(String myLotto, String answerLotto) {
        String[] myLottoArr = myLotto.split(", ");
        String[] answerLottoArr = answerLotto.split(", ");

        List<String> myLottoList = Arrays.asList(myLottoArr);
        List<String> answerLottoList = Arrays.asList(answerLottoArr);

        return (int) myLottoList.stream()
                .filter(answerLottoList::contains)
                .count();
    }
}
