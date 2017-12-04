package _06_Reflection.lab.L03_HighQualityMistakes;

import _06_Reflection.lab.Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Class rClass = Reflection.class;
        Field[] fields = rClass.getDeclaredFields();
        Method[] methods = rClass.getDeclaredMethods();
        Arrays.sort(fields, Comparator.comparing(Field::getName));
        Arrays.sort(methods, Comparator.comparing(Method::getName));

        for (Field f : fields) {
            if (!Modifier.isPrivate(f.getModifiers())) {
                System.out.printf("%s must be private!%n", f.getName());
            }
        }
        for (Method m : methods) {
            if (m.getName().startsWith("get") && !Modifier.isPublic(m.getModifiers())) {
                System.out.printf("%s have to be public!%n", m.getName());
            } else if (m.getName().startsWith("set") && !Modifier.isPrivate(m.getModifiers())) {
                System.out.printf("%s have to be private!%n", m.getName());
            }
        }
    }
}
