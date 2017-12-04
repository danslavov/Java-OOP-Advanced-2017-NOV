package _06_Reflection.lab.L02_GettersAndSetters;

import _06_Reflection.lab.Reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class thisClass = Reflection.class;
        Method[] allMethods = thisClass.getDeclaredMethods();
        Set<Method> getters = new HashSet<>();
        Set<Method> setters = new HashSet<>();
        for (Method method : allMethods) {
            String name = method.getName();
            if (name.startsWith("get")) {
                getters.add(method);
            } else if (name.startsWith("set")) {
                setters.add(method);
            }
        }

        getters
                .stream()
                .sorted(Comparator.comparing(Method::getName))
                .forEach(g -> {
                    System.out.printf(
                            "%s will return %s%n", g.getName(), g.getReturnType());
                });
        setters
                .stream()
                .sorted(Comparator.comparing(Method::getName))
                .forEach(s -> {
                    System.out.printf(
                            "%s and will set field of %s%n",
                            s.getName(), s.getParameterTypes()[0]);
                });
    }
}