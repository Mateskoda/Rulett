package WorkingArea;

public class Player {


    private String name;
    private int startingCapital;
    private int actualCapital;
    private boolean isIn=true;
    int [] betNumbers;    // if winnerNumber is one of these, then the player wins
    int winnersMultiplier; // if the risk is bigger,this number will be bigger too
    double previousBet ;
    int actuelBet;

    public int getActuelBet() {
        return actuelBet;
    }

    public Player(String name, int startingCapital) {
        this.name = name;
        this.startingCapital = startingCapital;
        actualCapital = startingCapital;
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

    public  void takeABet(){};

}

