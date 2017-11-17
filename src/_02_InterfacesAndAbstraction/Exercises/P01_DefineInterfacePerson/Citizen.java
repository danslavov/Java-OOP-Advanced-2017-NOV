package _02_InterfacesAndAbstraction.Exercises.P01_DefineInterfacePerson;

public class Citizen implements Person {

    private String name;
    private int age;

    public Citizen(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }
}
