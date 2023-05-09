package nz.ac.auckland.se281;

import java.util.ArrayList;

public class RandomStrategy implements Strategy {
    private int fingers;
    private int sum;

    @Override
    public void calculateFinger() {
        fingers = Utils.getRandomNumber(1, 5);
    }

    @Override
    public void calculateSum(ArrayList<Integer> fingerList) {
        sum = Utils.getRandomNumber(fingers + 1, fingers + 5);
        
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



