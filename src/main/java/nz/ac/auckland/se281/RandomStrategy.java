package nz.ac.auckland.se281;

import java.util.ArrayList;

public class RandomStrategy extends Strategy {

  @Override
  public void calculateSum(ArrayList<Integer> fingerList) {
    sum = Utils.getRandomNumber(fingers + 1, fingers + 5);
  }
}
