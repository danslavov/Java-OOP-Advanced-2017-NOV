package _05_EnumsAndAnnotations.lab.L04_CreateAnnotation;

public class Main {
    public static void main(String[] args) {

        @Subject(categories = {"a", "b"})
        class C {
        }
    }
}
