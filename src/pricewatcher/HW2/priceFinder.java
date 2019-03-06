package pricewatcher.HW2;

import java.util.Random;

public class priceFinder {
    public priceFinder(){

    }
    /**
     * simulates a price for the fixed item
     * */
    public double simulatedPrice(){
        Random random = new Random();
        double simulatedPrice = random.nextInt(100);
        return simulatedPrice;
    }
}
