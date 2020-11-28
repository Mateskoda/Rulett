package ActuallyNotUsedClasses;

public abstract class Strategy extends Player {
    Strategy strategy;

    public Strategy(String name, int startingCapital, Strategy strategy) {
        super(name, startingCapital);
        this.strategy=strategy;
    }
    public abstract void takeABet(Strategy strategy);


}
