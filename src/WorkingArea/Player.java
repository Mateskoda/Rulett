package WorkingArea;

public class Player {
//there could be also a player interface, if you have time to create it :)

    private String name;
    private int startingCapital;
    private int actualCapital;
    private int previousTurnCapital;
    private boolean isIn = true;
    private int[] betNumbers;    // if winnerNumber is one of these, then the player wins
    private int winnersMultiplier; // if the risk is bigger,this number will be bigger too
    private double previousBet = 0.5;
    private int actuelBet;
    private int sumOfRewards = actuelBet- startingCapital;

    public Player(String name, int startingCapital) {
        this.name = name;
        this.startingCapital = startingCapital;
        actualCapital = startingCapital;
        previousTurnCapital = startingCapital;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartingCapital(int startingCapital) {
        this.startingCapital = startingCapital;
    }

    public int getSumOfRewards() {
        return sumOfRewards;
    }

    public String getName() {
        return name;
    }

    public int getStartingCapital() {
        return startingCapital;
    }

    public int[] getBetNumbers() {
        return betNumbers;
    }

    public void setBetNumbers(int[] betNumbers) {
        this.betNumbers = betNumbers;
    }

    public int getWinnersMultiplier() {
        return winnersMultiplier;
    }

    public void setWinnersMultiplier(int winnersMultiplier) {
        this.winnersMultiplier = winnersMultiplier;
    }

    public double getPreviousBet() {
        return previousBet;
    }

    public void setPreviousBet(double previousBet) {
        this.previousBet = previousBet;
    }

    public int getActuelBet() {
        return actuelBet;
    }

    public void setActuelBet(int actuelBet) {
        this.actuelBet = actuelBet;
    }

    public int getPreviousTurnCapital() {
        return previousTurnCapital;
    }

    public void setPreviousTurnCapital(int previousTurnCapital) {
        this.previousTurnCapital = previousTurnCapital;
    }

    public int getActualCapital() {
        return actualCapital;
    }

    public void setActualCapital(int actualCapital) {
        this.actualCapital = actualCapital;
    }

    public boolean isIn() {
        return isIn;
    }

    public void setIn(boolean in) {
        isIn = in;
    }

    public void takeABet() {
    }
}

