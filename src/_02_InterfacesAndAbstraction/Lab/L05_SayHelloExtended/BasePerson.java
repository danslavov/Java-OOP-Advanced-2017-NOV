package _02_InterfacesAndAbstraction.Lab.L05_SayHelloExtended;

public abstract class BasePerson implements Person {

    private String name;

    protected BasePerson(String name) {
        setName(name);
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
