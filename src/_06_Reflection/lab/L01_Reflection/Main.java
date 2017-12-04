package _06_Reflection.lab.L01_Reflection;

import _06_Reflection.lab.Reflection;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class thisClass = Reflection.class;
        Class superClass = thisClass.getSuperclass();
        System.out.println(thisClass);
        System.out.println(superClass);
        Class[] interfaces = thisClass.getInterfaces();
        for (Class inter : interfaces) {
            System.out.println(inter);
        }
        Reflection newInstance = (Reflection) thisClass.newInstance();
        System.out.print(newInstance);
    }
}
