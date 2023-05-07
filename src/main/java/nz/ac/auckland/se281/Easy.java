package nz.ac.auckland.se281;


public class Easy implements AILevel {

    SetStrategy implementedStrategy = new SetStrategy(new RandomStrategy()); 

    @Override
    public int calculateFinger() {
        implementedStrategy.strategyCalculateFinger();
        return implementedStrategy.getFingers();
    }

    @Override
    public int calculateSum() {
        implementedStrategy.strategyCalculateSum();
        return implementedStrategy.getSum();
    }

    @Override
    public void changeStrategy() {

    }
    
}
