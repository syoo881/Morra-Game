package nz.ac.auckland.se281;

import java.util.ArrayList;

public interface AILevel {

    int calculateFinger();  
    int calculateSum(ArrayList<Integer> fingerList);
    void changeStrategy();    
}
