package nz.ac.auckland.se281;

public class Easy implements AILevel {

    SetStrategy EasyStrat = new SetStrategy(new RandomStrategy()); 

    @Override
    public int calculateFinger() {
        EasyStrat.strategyCalculateFinger();
        return EasyStrat.getFingers();
    }

    @Override
    public int calculateSum() {
        EasyStrat.strategyCalculateSum();
        return EasyStrat.getSum();
    }
    
}
