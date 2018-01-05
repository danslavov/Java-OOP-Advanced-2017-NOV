package _10_ObjectCommunicationAndEvents.ex.p03_dependency_inversion;

import _10_ObjectCommunicationAndEvents.ex.p03_dependency_inversion.interfaces.Strategy;
import _10_ObjectCommunicationAndEvents.ex.p03_dependency_inversion.strategy_impl.AdditionStrategy;
import _10_ObjectCommunicationAndEvents.ex.p03_dependency_inversion.strategy_impl.DivisionStrategy;
import _10_ObjectCommunicationAndEvents.ex.p03_dependency_inversion.strategy_impl.MultiplicationStrategy;
import _10_ObjectCommunicationAndEvents.ex.p03_dependency_inversion.strategy_impl.SubtractionStrategy;

public class StrategyFactory {

    public Strategy chooseStrategy(char operator) {

        switch (operator) {
            case '+':
                return new AdditionStrategy();
            case '-':
                return new SubtractionStrategy();
            case '*':
                return new MultiplicationStrategy();
            case '/':
                return new DivisionStrategy();
            default:
                return null;
        }
    }
}
