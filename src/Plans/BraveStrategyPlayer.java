package Plans;

import ActuallyNotUsedClasses.Strategy;

public class BraveStrategyPlayer extends Strategy {
    public BraveStrategyPlayer(String name, int startingCapital, Strategy strategy) {
        super(name, startingCapital, strategy);
    }

    @Override
    public void takeABet(Strategy strategy) {

    }
}
