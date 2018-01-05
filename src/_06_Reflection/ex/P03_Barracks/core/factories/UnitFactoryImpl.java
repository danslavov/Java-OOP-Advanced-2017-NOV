package _06_Reflection.ex.P03_Barracks.core.factories;

import _06_Reflection.ex.P03_Barracks.contracts.Unit;
import _06_Reflection.ex.P03_Barracks.contracts.UnitFactory;
import _06_Reflection.ex.P03_Barracks.models.units.Archer;
import _06_Reflection.ex.P03_Barracks.models.units.Pikeman;
import _06_Reflection.ex.P03_Barracks.models.units.Swordsman;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "_06_Reflection.ex.P03_Barracks.characters.units.";

    @Override
    public Unit createUnit(String unitType) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

//        switch (unitType) {
//            case "Archer":
//                return new Archer();
//            case "Pikeman":
//                return new Pikeman();
//            case "Swordsman":
//                return new Swordsman();
//            default:
//                return null;
//        }

        Class<?> unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
        Constructor<?> constructor = unitClass.getConstructor();
        return (Unit) constructor.newInstance();
    }
}
