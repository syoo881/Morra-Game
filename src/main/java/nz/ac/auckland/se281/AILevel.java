package nz.ac.auckland.se281;

import java.util.ArrayList;

public interface aiLevel {

    int calculateFinger();  
    int calculateSum(ArrayList<Integer> fingerList);
    void changeStrategyToAverage();  
    void changeStrategyToTop();  
}
