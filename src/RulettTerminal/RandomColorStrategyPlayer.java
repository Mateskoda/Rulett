package RulettTerminal;

import java.util.Random;

public class RandomColorStrategyPlayer extends Player {

    public RandomColorStrategyPlayer(String name, int startingCapital) {

        super(name, startingCapital);
    setWinnersMultiplier(1);
}

    @Override
    public void takeABet() {
        if (Math.random() <0.5) {
            setBetNumbers(new int[]{1, 3, 5, 7, 9, 12,
                14, 16, 18, 19, 21, 23,
                25, 27, 30, 32, 34, 36});
        Bet betName = Bet.RED;
    } else {
            setBetNumbers(new int[]{2, 4, 6, 8, 10, 11,
                    13, 15, 17, 20, 22, 24,
                    26, 28, 29, 31, 33, 35
            });
        }
                Bet betName = Bet.BLACK;
        setActuelBet(new Random().nextInt(10000));
        }

}



//        extends Strategy {
//
//    public RandomStrategyPlayer(String name, int startingCapital, Strategy strategy) {
//        super(name, startingCapital, strategy);
//    }
//
//    @Override
//    public void takeABet(Strategy strategy) {
//
//    }
//}
//