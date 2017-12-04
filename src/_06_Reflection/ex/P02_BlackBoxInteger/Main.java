package _06_Reflection.ex.P02_BlackBoxInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException,
            InstantiationException, IOException, NoSuchFieldException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Class blackBox = BlackBoxInt.class;
        BlackBoxInt instance = getInstance(blackBox);
        Field field = blackBox.getDeclaredField("innerValue");
        field.setAccessible(true);

        processInput(reader, blackBox, instance, field);
    }

    private static void processInput(BufferedReader reader, Class blackBox, BlackBoxInt instance, Field field) throws IOException, IllegalAccessException, InvocationTargetException {
        String input;
        while (!"END".equals(input = reader.readLine())) {
            String[] tokens = input.split("_");
            String methodName = tokens[0];
            int parameter = Integer.parseInt(tokens[1]);

            // invoke method and get field value
            Method[] methods = blackBox.getDeclaredMethods();
            for (Method m : methods) {
                m.setAccessible(true);
                if (m.getName().equals(methodName) && instance != null) {
                        m.invoke(instance, parameter);
                        System.out.println(field.get(instance));
                }
            }
        }
    }

    // instantiate object via constructor
    private static BlackBoxInt getInstance(Class blackBox) throws
            InstantiationException, IllegalAccessException, InvocationTargetException {

        BlackBoxInt instance = null;
        Constructor[] constructors = blackBox.getDeclaredConstructors();
        for (Constructor c : constructors) {
            c.setAccessible(true);
            if (c.getParameterCount() == 1) {
                if (c.getParameterTypes()[0].equals(int.class)) {
                    instance = (BlackBoxInt) c.newInstance(0);
                }
            }
        }
        return instance;
    }
}
