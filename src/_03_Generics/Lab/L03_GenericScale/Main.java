package _03_Generics.Lab.L03_GenericScale;

public class Main {
    public static void main(String[] args) {
        Scale<Double> scale = new Scale<>(0d, 0d);
        System.out.println(scale.getHeavier());
    }
}
