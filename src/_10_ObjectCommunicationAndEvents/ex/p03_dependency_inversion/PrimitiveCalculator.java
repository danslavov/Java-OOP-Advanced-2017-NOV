package _10_ObjectCommunicationAndEvents.ex.p03_dependency_inversion;


import _10_ObjectCommunicationAndEvents.ex.p03_dependency_inversion.interfaces.Strategy;
import _10_ObjectCommunicationAndEvents.ex.p03_dependency_inversion.strategy_impl.AdditionStrategy;

public class PrimitiveCalculator {

    private Strategy strategy;

    public PrimitiveCalculator(){
        this.strategy = new AdditionStrategy();
    }

    public void changeStrategy(Strategy strategy){
        this.strategy = strategy;
    }

    public int performCalculation(int firstOperand,int secondOperand){
        return this.strategy.Calculate(firstOperand, secondOperand);
    }
}
