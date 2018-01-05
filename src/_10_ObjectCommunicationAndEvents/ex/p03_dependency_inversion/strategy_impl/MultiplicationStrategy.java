package _10_ObjectCommunicationAndEvents.ex.p03_dependency_inversion.strategy_impl;

import _10_ObjectCommunicationAndEvents.ex.p03_dependency_inversion.interfaces.Strategy;

public class MultiplicationStrategy implements Strategy {
    public int Calculate(int firstOperand, int secondOperand){
        return firstOperand * secondOperand;
    }
}
