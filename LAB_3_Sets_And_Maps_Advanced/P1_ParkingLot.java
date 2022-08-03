package ADVANCED.LAB_3_Sets_And_Maps_Advanced;

import java.util.*;

public class P1_ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Set<String> set = new LinkedHashSet<>();

        while (!input.equals("END")) {
            String[] command = input.split(", ");
            String option = command[0];
            String carNumber = command[1];

            if (option.equals("IN")){
                set.add(carNumber);
            } else {
                set.remove(carNumber);
            }
            input = scanner.nextLine();
        }
        if(set.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }
        for (String element : set){
            System.out.println(element);
        }
    }
}
