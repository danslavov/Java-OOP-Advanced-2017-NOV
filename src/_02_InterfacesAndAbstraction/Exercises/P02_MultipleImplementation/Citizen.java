package _02_InterfacesAndAbstraction.Exercises.P02_MultipleImplementation;

public class Citizen implements Person, Identifiable, Birthable {

    private String name;
    private int age;
    private String id;
    private String birthday;


    public Citizen(String name, Integer age, String id, String birthdate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthday = birthdate;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String getBirthdate() {
        return this.birthday;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
