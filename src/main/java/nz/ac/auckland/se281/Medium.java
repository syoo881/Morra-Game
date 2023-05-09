package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Medium implements AILevel{

    
    /* Morra morra = new Morra();
        int numberOfRounds = morra.getNumberOfRounds(); */
    SetStrategy implementedStrategy = new SetStrategy(new RandomStrategy());

    @Override
    public void changeStrategy(){
        implementedStrategy.changeToAverageStrategy();
    }


    /* public void checkStrategy(){
        if (numberOfRounds == 4){
            //not sure if this will work tbh
            implementedStrategy.setStrategy(new AverageStrategy());
        }
    } */

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

}
