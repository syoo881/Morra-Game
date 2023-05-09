package nz.ac.auckland.se281;


//These imports might not be needed
import java.util.ArrayList;

public class AverageStrategy implements Strategy{
    private int fingers;
    private int sum;
    private int average = 0;

    @Override
    public void calculateFinger() {
        fingers = Utils.getRandomNumber(1, 5);
    }

    //Change the name of this. Call it calculateAverage, and separate the methods in the interface.es
    @Override
    public void calculateSum(ArrayList<Integer> fingerList) {
        
    for (int i = 0; i < (fingerList.size() - 1); i++) {
            average = average + fingerList.get(i);
        } 
        sum =  (int) Math.round((Double.valueOf(average) / (fingerList.size() - 1))) +  fingers;
    }

    @Override
    public int getFingers() {
    return fingers;
    }

    @Override
    public int getSum() {
    return sum;
    
    }

    
    
}
