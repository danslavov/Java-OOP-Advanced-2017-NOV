package _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator;

import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.Core.Engine;

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine();
        engine.Run();
    }
}
