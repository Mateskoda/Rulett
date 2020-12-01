package WorkingArea;

public class BelaStrategyPlayer extends Player {
    double startingPreviousBet;
//    his strategy is,that he starts with the lowest bet (1)
//    and every time he loose he double his previouse bet,
//    if he wins, he starts it from beginning

    public BelaStrategyPlayer(String name, int startingCapital, double stratingPreviousBet) {

        super(name, startingCapital);
        setPreviousBet(stratingPreviousBet);
        setWinnersMultiplier(1);
        this.startingPreviousBet = stratingPreviousBet;
    }

    @Override
    public void takeABet() {
        if (getPreviousTurnCapital() < getActualCapital()) {    //ha nyert az elozo korben
            setPreviousBet(startingPreviousBet);
        }
        if ((int) (getPreviousBet() * 2) <= RulettApp.getMaxBet()) {        //ha vesztett az elozo korben
            setActuelBet((int) (getPreviousBet() * 2));
        } else {
            setActuelBet(RulettApp.maxBet);
        }
        setBetNumbers(new int[]{1, 3, 5, 7, 9, 12,
                14, 16, 18, 19, 21, 23,
                25, 27, 30, 32, 34, 36});
        Bet betName = Bet.RED;
        setPreviousBet(getActuelBet());
    }

   /* public int[] getRangedBet() {
        switch (rangedBet) {
            case "odds":
            case "black":
                return new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 35, 37};
            case "evens":
                return new int[]{0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36};
            case "highs":
                return new int[]{19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37};
            case "lows":
                return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
            case "red":
                return new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36};
        }
        return null;
    }*/
}
