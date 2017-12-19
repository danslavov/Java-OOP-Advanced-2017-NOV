package _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.Utility;

public class Validator
{
    public static void validatePropertyValue(int value, String propertyName) {
        if (value <= 0) {
            throw new IllegalArgumentException(String.format(
                    Constants.INCORRECT_PROPERTY_VALUE_MESSAGE, propertyName));
        }
    }

    public static void validateModelLength(String name, int minModelLength) {
        if (name.length() < minModelLength) {
            throw new IllegalArgumentException(String.format(
                    Constants.INCORRECT_MODEL_LENGTH_MESSAGE, minModelLength));
        }
    }
}
