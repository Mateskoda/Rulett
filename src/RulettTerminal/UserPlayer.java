package RulettTerminal;

public class UserPlayer extends Player {
    int bet;
    String betName;

    public UserPlayer(String name, int startingCapital, String betName, int bet) {

        super(name, startingCapital);
        setWinnersMultiplier(1);
        this.bet = bet;
        this.betName = betName;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public void setBetName(String betName) {
        this.betName = betName;
    }

    @Override
    public void takeABet() {
        if (bet <= RulettApp.getMaxBet()) {
            setActuelBet(bet);
        } else {
            setActuelBet(RulettApp.maxBet);
        }
        if (betName.equals("red")) {
            setBetNumbers(new int[]{1, 3, 5, 7, 9, 12,
                    14, 16, 18, 19, 21, 23,
                    25, 27, 30, 32, 34, 36});
            Bet betName = Bet.RED;
        }
    }

}
