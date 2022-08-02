package ADVANCED.EXERCISE_6_Defining_Classes.P3_SpeedRacing;

public class Car {
    private String model;
    private double fuel;
    private double fuelCost;
    private int distance;

    public Car(String model, double fuelAmount, double fuelCost) {
        this.model = model;
        this.fuel = fuelAmount;
        this.fuelCost = fuelCost;
        this.distance = 0;
    }

    public boolean canItDrive(int distanceDrive) {
        //разстояние -> колко гориво ще ни отнеме
        double needFuel = distanceDrive * this.fuelCost;
        if (needFuel <= this.fuel) {
            //изминаваме разстоянието
            this.distance += distanceDrive;
            this.fuel -= needFuel;
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return String.format("%s %.2f %d", this.model, this.fuel, this.distance);
    }
}
