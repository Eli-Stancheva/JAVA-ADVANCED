package ADVANCED.EXERCISE_6_Defining_Classes.P5_CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Engine> engines = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            Engine engine = null;

            String[] engineInfo = scanner.nextLine().split(" ");

            String engineModel = engineInfo[0];
            int enginePower = Integer.parseInt(engineInfo[1]);

            if (engineInfo.length == 4) {
                int engineDisplacement = Integer.parseInt(engineInfo[2]);
                String engineEfficiency = engineInfo[3];
                engine = new Engine(engineModel, enginePower, engineDisplacement, engineEfficiency);
            } else if (engineInfo.length == 3) {
                String thirdLine = engineInfo[2];
                if (Character.isDigit(thirdLine.charAt(0))) {
                    int engineDisplacement = Integer.parseInt(engineInfo[2]);
                    engine = new Engine(engineModel, enginePower, engineDisplacement);
                } else {
                    String engineEfficiency = engineInfo[2];
                    engine = new Engine(engineModel, enginePower, engineEfficiency);
                }
            } else if (engineInfo.length == 2) {
                engine = new Engine(engineModel, enginePower);
            }
            engines.add(engine);
        }

        List<Car> carList = new ArrayList<>();
        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < m; i++) {
            Car car = null;

            String[] carInfo = scanner.nextLine().split(" ");

            String model = carInfo[0];
            String engine = carInfo[1];

            if (carInfo.length == 4) {
                int weight = Integer.parseInt(carInfo[2]);
                String color = carInfo[3];
                car = new Car(model, engine, weight, color);
            } else if (carInfo.length == 3) {
                String thirdLine = carInfo[2];
                if (Character.isDigit(thirdLine.charAt(0))) {
                    int weight = Integer.parseInt(carInfo[2]);
                    car = new Car(model, engine, weight);
                } else {
                    String color = carInfo[2];
                    car = new Car(model, engine, color);
                }
            } else if (carInfo.length == 2) {
                car = new Car(model, engine);
            }
            carList.add(car);
        }

        for (Car car : carList) {
            System.out.println(car.getCarModel() + ":");
            System.out.println(car.getEngineModel() + ":");
            engines.forEach(e -> {
                if (e.getEngineModel().equals(car.getEngineModel())) {
                    System.out.println(e);
                }
            });
            if (car.getWeight() == 0) {
                System.out.println("Weight: n/a");
            } else {
                System.out.println("Weight: " + car.getWeight());
            }
            System.out.println("Color: " + car.getColor());
        }
    }
}
