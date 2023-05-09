package nz.ac.auckland.se281;

import java.util.ArrayList;

public interface Strategy {
  void calculateFinger();  
  void calculateSum(ArrayList<Integer> fingerList);
  int getFingers();
  int getSum();
}