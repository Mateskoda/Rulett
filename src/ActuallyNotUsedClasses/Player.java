package ActuallyNotUsedClasses;

public class Player {
    private String name;
    private int startingCapital;
    private int actualCapital;
    private boolean isIn=true;


    public Player(String name, int startingCapital) {
        this.name = name;
        this.startingCapital = startingCapital;
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
}
