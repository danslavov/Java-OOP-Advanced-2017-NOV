package app.factories;

import app.contracts.Action;
import app.contracts.ActionFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ActionFactoryImpl implements ActionFactory {

    private String path;

    public ActionFactoryImpl(String path) {
        this.path = path;
    }

    @Override
    public Action create(String actionName, String... participantNames) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        String actionFullName = path + actionName;
        Class<?> actionClass = Class.forName(actionFullName);
        Constructor<?> actionConstructor = actionClass.getDeclaredConstructors()[0];
        actionConstructor.setAccessible(true);
        return (Action) actionConstructor.newInstance();
    }
}
