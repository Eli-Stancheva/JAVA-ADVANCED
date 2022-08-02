package ADVANCED.EXERCISE_6_Defining_Classes.P3_SpeedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Car> carMap = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] carInfo = scanner.nextLine().split(" ");

            String model = carInfo[0];
            int fuelAmount = Integer.parseInt(carInfo[1]);
            double fuelCost = Double.parseDouble(carInfo[2]);

            Car car = new Car(model, fuelAmount, fuelCost);
            carMap.put(model, car);
        }

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] data = input.split(" ");

            String model = data[1];
            int amountOfKm = Integer.parseInt(data[2]);

            Car carToDrive = carMap.get(model);

            if(!carToDrive.canItDrive(amountOfKm)){
                System.out.println("Insufficient fuel for the drive");
            }

            input = scanner.nextLine();
        }
        for (Car car : carMap.values()){
            System.out.println(car.toString());
        }
    }
}
