package WorkingArea;

public class BelaStrategyPlayer extends Player {


    public BelaStrategyPlayer(String name, int startingCapital) {

        super(name, startingCapital);
        previousBet = 0.5;
        winnersMultiplier=1;

    }

//    public int getActuelBet() {
//        return actuelBet;
//    }

    @Override
    public void takeABet() {
        actuelBet = (int) (previousBet * 2);
         betNumbers = new int[]{1, 3, 5, 7, 9, 12,
                 14, 16, 18, 19, 21, 23,
                 25, 27, 30, 32, 34, 36};
        Bet betName = Bet.RED;
        previousBet = actuelBet;
    }

}
