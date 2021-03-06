package _02_InterfacesAndAbstraction.Lab.L04_SayHello;

public class European implements Person {

    private String name;

    public European(String name) {
        setName(name);
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
