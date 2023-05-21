package nz.ac.auckland.se281;

import java.util.ArrayList;

public abstract class Strategy {

  protected int fingers;
  protected int sum;

  void calculateFinger() {
    fingers = Utils.getRandomNumber(1, 5);
  }

  void calculateSum(ArrayList<Integer> fingerList) {}

  int getFingers() {
    return fingers;
  }

  int getSum() {
    return sum;
  }
}
