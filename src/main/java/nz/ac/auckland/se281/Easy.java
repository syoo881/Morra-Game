package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Easy implements AILevel {

    SetStrategy implementedStrategy = new SetStrategy(new RandomStrategy()); 

    @Override
    public int calculateFinger() {
        implementedStrategy.strategyCalculateFinger();
        return implementedStrategy.getFingers();
    }

    @Override
    public int calculateSum(ArrayList<Integer> fingerList) {
        implementedStrategy.strategyCalculateSum(fingerList);
        return implementedStrategy.getSum();
    }

    @Override
    public void changeStrategy() {

    }
    
}
