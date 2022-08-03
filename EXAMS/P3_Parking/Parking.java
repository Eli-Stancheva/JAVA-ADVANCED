package ADVANCED.EXAMS.Exam_9_28_June_2020.P3_Parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private List<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (capacity > data.size()) {
            data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        for (Car c : data) {
            if (c.getManufacturer().equals(manufacturer) && c.getModel().equals(model)) {
                data.remove(c);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        Car latestCar = null;
        int latest = Integer.MIN_VALUE;
        for (Car c : data) {
            if (c.getYear() > latest) {
                latest = c.getYear();
                latestCar = c;
            }
        }
        return latestCar;
    }

    public Car getCar(String manufacturer, String model) {
        for (Car c : data) {
            if (c.getManufacturer().equals(manufacturer) && c.getModel().equals(model)) {
                return c;
            }
        }
        return null;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The cars are parked in ").append(this.type).append(":\n");
        for (Car car : this.data){
            stringBuilder.append(car.toString()).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
