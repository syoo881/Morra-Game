package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;

public class AverageStrategy implements Strategy{
    private int fingers;
    private int sum;
    private int average = 0;
    private List<Integer> fingerList = new ArrayList<Integer>();

    @Override
    public void calculateFinger() {
        fingers = Utils.getRandomNumber(1, 5);
    }

    @Override
    public void calculateSum() {
        //This here might be sketch. creating an instance is an interesting way of doing this.

        //this morra thing does work. The issue is the Morra.java GetFingerList method, 
        //Where the fingerList is an empty arraylist.
    Morra morra = new Morra();
    //set average to the sum of the morra.getFingerList() arraylist excluding the last element
    fingerList = morra.getFingerList();
    for (int i = 0; i < (fingerList.size()); i++) {
            average = average + fingerList.get(i);
        }



        /* for (int i = 0; i < (morra.getFingerList().size() - 1); i++) {
            average = average + morra.getFingerList().get(i);
        } */
        //sum might be incorrect, so double check later
        /* sum = (int) Math.round((Double.valueOf(average) / morra.getFingerList().size() - 1)) + fingers; */
        sum = average;
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
