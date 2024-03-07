package org.example.assignment;

import java.util.*;
import java.util.Map.Entry;

public class Week1_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("총 진행할 투표수를 입력해 주세요.");
        int totalVote = Integer.parseInt(scanner.nextLine());

        System.out.print("가상 선거를 진행할 후보자 인원을 입력해 주세요.");
        int member = Integer.parseInt(scanner.nextLine());

        String[] members = new String[member];
        Map<String, Integer> memberValue = new HashMap<>();
        for (int i = 0; i < member; i++) {
            System.out.printf("%d번째 후보자이름을 입력해 주세요.", i + 1);
            members[i] = scanner.nextLine();
            memberValue.put(members[i], 0);
        }

        for (int i = 1; i <= totalVote; i++) {
            String whoVote = members[(int) (Math.random() * member)];
            memberValue.put(whoVote, memberValue.get(whoVote) + 1);
            System.out.printf("[투표진행률]: %.2f%%, %d명 투표 => %s\n", (double) i * 100 / totalVote, i, whoVote);
            for (int j = 0; j < member; j++) {
                System.out.printf("[기호:%d] %s:\t%.2f%%\t(투표수 : %d)\n", j + 1, members[j], (double) memberValue.get(members[j]) * 100 / totalVote, memberValue.get(members[j]));
            }
            System.out.println();
        }

        int maxValue = Integer.MIN_VALUE;
        Set<String> election = new HashSet<>();
        for (Entry<String, Integer> entry : memberValue.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
            }
        }

        for (Entry<String, Integer> entry : memberValue.entrySet()) {
            if (entry.getValue() == maxValue) {
                election.add(entry.getKey());
            }
        }

        System.out.print("[투표결과] 당선인 : ");
        StringBuilder sb = new StringBuilder();
        for (String s : election) {
            sb.append(s + ", ");
        }
        sb.setLength(sb.length() - 2);
        System.out.println(sb);
    }
}
