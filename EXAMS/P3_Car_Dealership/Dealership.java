package ADVANCED.EXAMS.Exam_6_20_February_2021.P3_Car_Dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    public List<Car> data;
    public String name;
    public int capacity;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (capacity > data.size()) {
            data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        Car carToRemove = null;
        for (Car c : data) {
            if (c.getManufacturer().equals(manufacturer) && c.model.equals(model)) {
                carToRemove = c;
            }
        }

        if (carToRemove == null) {
            return false;
        } else {
            data.remove(carToRemove);
            return true;
        }
    }

    public Car getLatestCar() {
        Car oldestCar = null;
        int oldest = Integer.MIN_VALUE;

        for (Car c : data) {
            if (c.getYear() > oldest) {
                oldest = c.getYear();
                oldestCar = c;
            }
        }
        return oldestCar;
    }

    public Car getCar(String manufacturer, String model) {
        Car car = null;
        for (Car c : data) {
            if (c.getManufacturer().equals(manufacturer) && c.getModel().equals(model)) {
                car = c;
            }
        }
        return car;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("The cars are in a car dealership %s:\n", name));
        for (Car car : data) {
            builder.append(car).append("\n");
        }
        return builder.toString();
    }
}
