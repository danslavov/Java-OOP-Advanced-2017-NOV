package _02_InterfacesAndAbstraction.Lab.L03_CarShopExtend;

public class Seat extends CarImp implements Sellable {

    private double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        setPrice(price);
    }

    private void setPrice(double price) {
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}
