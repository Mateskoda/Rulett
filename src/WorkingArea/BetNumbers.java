package WorkingArea;

public class BetNumbers { public int [] BetNumber(Bet betName) {
    int[] betNumbers = new int[0];

//        if (betName.equals(Bet.ROW)) {
//            betNumbers = new int[]{};
//        }

//        if (betName.equals(Bet.SPLIT)) {
//            betNumbers = new int[]{};
//        }

    if (betName.equals(Bet.TOP_LINE)) {
        betNumbers = new int[]{0, 1, 2, 3};
    }

    else if (betName.equals(Bet.FIRST_COLUMN)) {
        betNumbers = new int[]{ 1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34 };
    }
    else if (betName.equals(Bet.SECOND_COLUMN)) {
        betNumbers = new int[]{2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35};
    }
    else if (betName.equals(Bet.THIRD_COLUMN)) {
        betNumbers = new int[]{3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36};
    }
    else if (betName.equals(Bet.FIRST_DOZEN)) {
        betNumbers = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    }
    else if (betName.equals(Bet.SECOND_DOZEN)) {
        betNumbers = new int[]{13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
    }
    else if (betName.equals(Bet.THIRD_DOZEN)) {
        betNumbers = new int[]{25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36};
    }
    else if (betName.equals(Bet.ONE_TO_EIGHTTEEN)) {
        betNumbers = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
    }
    else if (betName.equals(Bet.NINETEEN_TO_THIRTYSIX)) {
        betNumbers = new int[]{ 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36};
    }
    else if (betName.equals(Bet.ODD)) {
        betNumbers = new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 35};
    }
    else if (betName.equals(Bet.EVEN)) {
        betNumbers = new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36};
    }
    else if (betName.equals(Bet.RED)) {
        betNumbers = new int[]{1, 3, 5, 7, 9, 12,
                14, 16, 18, 19, 21, 23,
                25, 27, 30, 32, 34, 36};
    }
    else if (betName.equals(Bet.BLACK)) {
        betNumbers = new int[]{2, 4, 6, 8, 10, 11,
                13, 15, 17, 20, 22, 24,
                26, 28, 29, 31, 33, 35};
    }
    else if (betName.equals(Bet.LOW)) {
        betNumbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
    }
    else if (betName.equals(Bet.HIGH)) {
        betNumbers = new int[]{19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36}; }

    return betNumbers;}

    public int [] BetNumber(Bet betName,int num) {
        int[] betNumbers = new int[0];
        if (betName.equals(Bet.STRAIGHT_UP)) {
            betNumbers = new int[]{num};
        }

        else if (betName.equals(Bet.STREET)) {
            betNumbers = new int[]{num,num+1,num+2};
        }
        else if (betName.equals(Bet.CORNER)) {
            betNumbers = new int[]{num,num+1,num+2,num+3}; }


                return betNumbers;}

public int [] BetNumber(Bet betName,int num,int num2) {
        int[] betNumbers = new int[0];
        if (betName.equals(Bet.SIX_LINE)) {
        betNumbers = new int[]{num,num+1,num+2,num+3,num+4,num+5,num2,num2+1,num2+2,num2+3,num2+4,num2+5};
        }

        return betNumbers;}
        }
