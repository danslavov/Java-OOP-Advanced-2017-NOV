package _06_Reflection.ex.P03_Barracks;

import _06_Reflection.ex.P03_Barracks.contracts.Repository;
import _06_Reflection.ex.P03_Barracks.contracts.UnitFactory;
import _06_Reflection.ex.P03_Barracks.core.Engine;
import _06_Reflection.ex.P03_Barracks.core.factories.UnitFactoryImpl;
import _06_Reflection.ex.P03_Barracks.data.UnitRepository;

public class Main {

	public static void main(String[] args) {
		Repository repository = new UnitRepository();
		UnitFactory unitFactory = new UnitFactoryImpl();
		Runnable engine = new Engine(repository, unitFactory);
		engine.run();
	}
}
