package WorkingArea;

public class Multiplier {

    public int multiplier(Bet betName) {
        int multiplier = 0;
        if (betName.equals(Bet.TOP_LINE)) {
            multiplier = 8;
        } else if (betName.equals(Bet.FIRST_COLUMN)) {
            multiplier = 2;
        } else if (betName.equals(Bet.SECOND_COLUMN)) {
            multiplier = 2;
        } else if (betName.equals(Bet.THIRD_COLUMN)) {
            multiplier = 2;
        } else if (betName.equals(Bet.FIRST_DOZEN)) {
            multiplier = 2;
        } else if (betName.equals(Bet.SECOND_DOZEN)) {
            multiplier = 2;
        } else if (betName.equals(Bet.THIRD_DOZEN)) {
            multiplier = 2;
        } else if (betName.equals(Bet.ONE_TO_EIGHTTEEN)) {
            multiplier = 2;
        } else if (betName.equals(Bet.NINETEEN_TO_THIRTYSIX)) {
            multiplier = 2;
        } else if (betName.equals(Bet.ODD)) {
            multiplier = 1;
        } else if (betName.equals(Bet.EVEN)) {
            multiplier = 1;
        } else if (betName.equals(Bet.RED)) {
            multiplier = 1;
        } else if (betName.equals(Bet.BLACK)) {
            multiplier = 1;
        } else if (betName.equals(Bet.LOW)) {
            multiplier = 1;
        } else if (betName.equals(Bet.HIGH)) {
            multiplier = 1;
        }

        if (betName.equals(Bet.STRAIGHT_UP)) {
            multiplier = 35;
        } else if (betName.equals(Bet.STREET)) {
            multiplier = 11;
        } else if (betName.equals(Bet.CORNER)) {
            multiplier = 8;
        } else if (betName.equals(Bet.SIX_LINE)) {
            multiplier = 5;
        }

        return multiplier;
    }

}
