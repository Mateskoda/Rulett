package RulettTerminal;


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

}
