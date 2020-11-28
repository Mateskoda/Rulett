package ActuallyNotUsedClasses;

import ActuallyNotUsedClasses.Strategy;

import java.util.ArrayList;

public class BelaStrategyPlayer extends Strategy {
 private int previousBet = 1;

    public BelaStrategyPlayer(String name, int startingCapital, Strategy strategy) {
        super(name, startingCapital, strategy);
    }

    @Override
    public void takeABet(Strategy strategy) {
        ArrayList betNumbers= new ArrayList();



    }
}
