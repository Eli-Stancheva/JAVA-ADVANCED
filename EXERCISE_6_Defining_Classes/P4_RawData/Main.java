package ADVANCED.EXERCISE_6_Defining_Classes.P4_RawData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> carList = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] carInfo = scanner.nextLine().split(" ");
            String carModel = carInfo[0];

            int engineSpeed = Integer.parseInt(carInfo[1]);
            int enginePower = Integer.parseInt(carInfo[2]);
            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(carInfo[3]);
            String cargoType = carInfo[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            double tire1Pressure = Double.parseDouble(carInfo[5]);
            int tire1Age = Integer.parseInt(carInfo[6]);
            double tire2Pressure = Double.parseDouble(carInfo[7]);
            int tire2Age = Integer.parseInt(carInfo[8]);
            double tire3Pressure = Double.parseDouble(carInfo[9]);
            int tire3Age = Integer.parseInt(carInfo[10]);
            double tire4Pressure = Double.parseDouble(carInfo[11]);
            int tire4Age = Integer.parseInt(carInfo[12]);
            Tire tire = new Tire(tire1Pressure, tire1Age, tire2Pressure, tire2Age, tire3Pressure, tire3Age, tire4Pressure, tire4Age);
            List<Tire> tireList = new ArrayList<>();
            Collections.addAll(tireList, tire);

            Car car = new Car(carModel, engine, cargo, tireList);
            carList.add(car);
        }


        List<String> fragileList = new ArrayList<>();
        List<String> flamableList = new ArrayList<>();

        String searchedCommand = scanner.nextLine();
        switch (searchedCommand) {
            case "fragile":
                for (Car car : carList) {
                    for (Tire tire : car.getTires()) {
                        if (car.getCargo().getCargoType().equals("fragile") && (tire.getTire1Pressure() < 1 || tire.getTire2Pressure() < 1 || tire.getTire3Pressure() < 1 || tire.getTire4Pressure() < 1)) {
                            fragileList.add(car.getModel());
                        }
                    }
                }
                fragileList.forEach(System.out::println);
                break;
            case "flamable":
                for (Car car : carList) {
                    if (car.getCargo().getCargoType().equals("flamable") && car.getEngine().getEnginePower() > 250) {
                        flamableList.add(car.getModel());
                    }
                }
                flamableList.forEach(System.out::println);
                break;
        }
    }
}
