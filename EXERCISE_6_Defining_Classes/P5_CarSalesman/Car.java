package ADVANCED.EXERCISE_6_Defining_Classes.P5_CarSalesman;

public class Car {
    private String carModel;
    private String engineModel;
    //optional
    private int weight;
    private String color;

    public Car(String carModel, String engine, int weight, String color) {
        this.carModel = carModel;
        this.engineModel = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String carModel, String engine, int weight) {
        this.carModel = carModel;
        this.engineModel = engine;
        this.weight = weight;
        this.color = "n/a";
    }

    public Car(String carModel, String engine, String color) {
        this.carModel = carModel;
        this.engineModel = engine;
        this.color = color;
        this.weight = 0;
    }

    public Car(String carModel, String engine) {
        this.carModel = carModel;
        this.engineModel = engine;
        this.weight = 0;
        this.color = "n/a";
    }

    public String getCarModel() {
        return carModel;
    }

    public String getEngineModel() {
        return engineModel;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }
}
