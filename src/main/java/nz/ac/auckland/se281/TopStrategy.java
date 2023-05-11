package nz.ac.auckland.se281;

import java.util.ArrayList;

public class TopStrategy extends Strategy {

  private int top;

  @Override
  public void calculateSum(ArrayList<Integer> fingerList) {
    top = calculateMode(fingerList);
    sum = top + fingers;
  }

  private int calculateMode(ArrayList<Integer> fingerList) {
    // find the most repeated value of fingerList array
    int maxValue = 0, maxCount = 0;

    for (int i = 0; i < fingerList.size(); ++i) {
      int count = 0;
      for (int j = 0; j < fingerList.size(); ++j) {
        if (fingerList.get(j) == fingerList.get(i)) ++count;
      }
      if (count > maxCount) {
        maxCount = count;
        maxValue = fingerList.get(i);
      }
    }
    return maxValue;
  }
}
