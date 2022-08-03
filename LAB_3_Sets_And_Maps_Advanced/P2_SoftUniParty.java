package ADVANCED.LAB_3_Sets_And_Maps_Advanced;

import java.util.*;

public class P2_SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> guest = new TreeSet<>();

        String input = scanner.nextLine();
        while (!input.equals("PARTY")) {
            guest.add(input);
            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("END")) {
            guest.remove(input);
            input = scanner.nextLine();
        }
        System.out.println(guest.size());
        guest.forEach(System.out::println);
    }
}
