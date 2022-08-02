package ADVANCED.EXERCISE_3_Sets_And_Maps_Advanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P5_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebook = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("search")) {
            String[] info = input.split("-");
            phonebook.put(info[0], info[1]);
            input = scanner.nextLine();
        }

        String input2 = scanner.nextLine();
        while (!input2.equals("stop")) {
            String searching = input2;
            if (phonebook.containsKey(searching)) {
                System.out.printf("%s -> %s\n", searching, phonebook.get(searching));
            } else {
                System.out.printf("Contact %s does not exist.\n", searching);
            }
            input2 = scanner.nextLine();
        }
    }
}
