package panzer;

import panzer.contracts.*;
import panzer.core.PanzerBattleOperator;
import panzer.io.ConsoleReader;
import panzer.io.ConsoleWriter;
import panzer.models.miscellaneous.Engine;
import panzer.models.miscellaneous.Factory;
import panzer.models.miscellaneous.VehicleAssembler;
import panzer.models.miscellaneous.VehicleManager;

public class Main {
    public static void main(String[] args) {

        String vehiclePath = "panzer.models.vehicles.";
        String partPath = "panzer.models.parts.";
        Assembler assembler = new VehicleAssembler();
        InputReader reader = new ConsoleReader();
        OutputWriter writer = new ConsoleWriter();
        Factory factory = new Factory(assembler, vehiclePath, partPath);
        BattleOperator battleOperator = new PanzerBattleOperator();
        Manager manager = new VehicleManager(battleOperator, factory);
        Engine engine = new Engine(reader, writer, manager);
        engine.run();
        
    }
}
