package _06_Reflection.ex.P01_Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Class myClass = RichSoilLand.class;
        Field[] fields = myClass.getDeclaredFields();

        String input;
        while (!"HARVEST".equals(input = reader.readLine()))
            switch (input) {
                case "private":
                    iterateFields(fields, "isPrivate");
                    break;
                case "protected":
                    iterateFields(fields, "isProtected");
                    break;
                case "public":
                    iterateFields(fields, "isPublic");
                    break;
                case "all":
                    iterateFields(fields);
                    break;
            }
    }

    private static void iterateFields(Field[] fields, String methodName)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        for (Field f : fields) {
            Method m = Modifier.class.getDeclaredMethod(methodName, int.class);
            boolean hasNeededModifier = (boolean) m.invoke(null, f.getModifiers());
            if (hasNeededModifier) {
                printField(f);
            }
        }
    }

    private static void iterateFields(Field[] fields) {
        for (Field f : fields) {
            printField(f);
        }
    }

    private static void printField(Field f) {
        String fullTypeName = f.getType().toString();
        String simpleTypeName = fullTypeName.substring(fullTypeName.lastIndexOf('.') + 1);
        System.out.printf("%s %s %s%n",
                Modifier.toString(f.getModifiers()), simpleTypeName, f.getName());
    }
}
