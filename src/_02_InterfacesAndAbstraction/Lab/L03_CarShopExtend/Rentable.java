package _02_InterfacesAndAbstraction.Lab.L03_CarShopExtend;

public interface Rentable extends Car {
    Integer getMinRentDay();
    Double getPricePerDay();
}
