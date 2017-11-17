package _02_InterfacesAndAbstraction.Exercises.P03_Ferrari;

public class Ferrari implements Car {
    private static final String MODEL = "488-Spider";

    private String driver;

    Ferrari(String driver) {
        this.driver = driver;
    }

    public String getModel() {
        return MODEL;
    }

    public String getDriver() {
        return this.driver;
    }

    @Override
    public void pushBrakes() {
        System.out.print("Brakes!");
    }

    @Override
    public void pushGas() {
        System.out.print("Zadu6avam sA!");
    }
}
