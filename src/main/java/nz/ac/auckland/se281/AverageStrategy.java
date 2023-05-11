package nz.ac.auckland.se281;

import java.util.ArrayList;

public class AverageStrategy extends Strategy {
  private int average = 0;

  @Override
  public void calculateSum(ArrayList<Integer> fingerList) {
    for (int i = 0; i < (fingerList.size() - 1); i++) {
      average = average + fingerList.get(i);
    }
    sum = (int) Math.round((Double.valueOf(average) / (fingerList.size() - 1))) + fingers;
  }
}
