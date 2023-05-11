package nz.ac.auckland.se281;

import java.util.ArrayList;

public class EasyLevel implements AiLevel {

  private SetStrategy implementedStrategy = new SetStrategy(new RandomStrategy());

  @Override
  public void changeStrategyToAverage() {}

  @Override
  public void changeStrategyToTop() {}

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
