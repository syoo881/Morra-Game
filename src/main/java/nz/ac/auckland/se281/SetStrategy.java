package nz.ac.auckland.se281;

public class SetStrategy {

    private Strategy strategy;
    public SetStrategy(Strategy strategy) {
        this.strategy = strategy;

    }

    public void strategyCalculateFinger() {
        strategy.calculateFinger();
    }

    public void strategyCalculateSum() {
        strategy.calculateSum();
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int getFingers() {
        return strategy.getFingers();
    }

    public int getSum() {
        return strategy.getSum();
    }

    public void changeToAverageStrategy() {
        setStrategy(new AverageStrategy());
    }
    
}
