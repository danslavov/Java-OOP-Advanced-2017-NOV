package _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.models.motors;

public class Jet extends Motor {

    private static final int MULTIPLIER = 5;

    public Jet(String model, int horsepower, int displacement) {
        super(model, horsepower, displacement);
    }

    @Override
    public int getOutput() {
        return super.getHorsepower() * MULTIPLIER + super.getDisplacement();
    }
}
