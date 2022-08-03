package ADVANCED.LAB_6_Defining_Classes.P2_Constructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> carsList = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] carInfo = scanner.nextLine().split(" ");
            Car car;

            if (carInfo.length == 1) {
                car = new Car(carInfo[0]);
            } else {
                car = new Car(carInfo[0], carInfo[1], Integer.parseInt(carInfo[2]));
            }
            carsList.add(car);
        }
        carsList.forEach(e -> System.out.println(e.carInfo()));
    }
}
