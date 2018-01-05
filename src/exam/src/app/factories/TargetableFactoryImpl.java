package app.factories;

import app.contracts.Targetable;
import app.contracts.TargetableFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TargetableFactoryImpl implements TargetableFactory {

    private String path;

    public TargetableFactoryImpl(String path) {
        this.path = path;
    }

    @Override
    public Targetable create(String targetableName, String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        String targetableFullName = path + className;
        Class<?> targetableClass = Class.forName(targetableFullName);
        Constructor<?> targetableConstructor = targetableClass.getDeclaredConstructors()[1];
        targetableConstructor.setAccessible(true);
        return (Targetable) targetableConstructor.newInstance(targetableName);
    }
}
