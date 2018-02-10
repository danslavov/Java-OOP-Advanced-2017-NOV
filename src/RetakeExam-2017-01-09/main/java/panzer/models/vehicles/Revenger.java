package panzer.models.vehicles;

import panzer.contracts.Assembler;

import java.math.BigDecimal;

public class Revenger extends BaseVehicle {

    public Revenger(String model, double weight, BigDecimal price, long attack, long defense, long hitPoints, Assembler assembler) {
        super(
                model,
                weight,
                price.add(
                        (price.multiply(new BigDecimal("50")))
                                .divide(new BigDecimal("100"))),
                attack + (attack * 150 / 100),
                defense - (defense * 50 / 100),
                hitPoints - (hitPoints * 50 / 100),
                assembler);
    }
}
