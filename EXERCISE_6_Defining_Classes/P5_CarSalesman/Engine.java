package ADVANCED.EXERCISE_6_Defining_Classes.P5_CarSalesman;

public class Engine {
    private String engineModel;
    private int enginePower;
    //optional
    private int engineDisplacement;
    private String engineEfficiency;

    public Engine(String engineModel, int enginePower, int engineDisplacement, String engineEfficiency) {
        this.engineModel = engineModel;
        this.enginePower = enginePower;
        this.engineDisplacement = engineDisplacement;
        this.engineEfficiency = engineEfficiency;
    }

    public Engine(String engineModel, int enginePower) {
        this.engineModel = engineModel;
        this.enginePower = enginePower;
        this.engineDisplacement = 0;
        this.engineEfficiency = "n/a";
    }

    //Constructor without engineEfficiency
    public Engine(String engineModel, int enginePower, int engineDisplacement) {
        this.engineModel = engineModel;
        this.enginePower = enginePower;
        this.engineDisplacement = engineDisplacement;
        this.engineEfficiency = "n/a";
    }

    //Constructor without engineDisplacement
    public Engine(String engineModel, int enginePower, String engineEfficiency) {
        this.engineModel = engineModel;
        this.enginePower = enginePower;
        this.engineEfficiency = engineEfficiency;
        this.engineDisplacement = 0;
    }

    public String getEngineModel() {
        return engineModel;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Power: ").append(enginePower).append("\n");

        if (engineDisplacement == 0){
            builder.append("Displacement: n/a").append("\n");
        } else {
            builder.append("Displacement: ").append(engineDisplacement).append("\n");
        }
        builder.append("Efficiency: ").append(engineEfficiency);
        return builder.toString();
    }
}
