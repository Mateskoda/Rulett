package WorkingArea;

import java.util.ArrayList;

public class RulettApp {
//    So...
//      In the main we create the list players.
//    In one turn players take their bets;
//    After we spin the wheel and get the winnernumber.
//    If the player wins, his Capital will grow,
//    otherwise he will lose his bet(money).
//        System.out.println();

//
   static ArrayList<Player> players = new ArrayList<>();
   static ArrayList<Player> actualWinners = new ArrayList<>();
    static int winnerNumber;


    public static void main(String[] args) {
        RulettApp rp = new RulettApp();
        BelaStrategyPlayer p1 = new BelaStrategyPlayer("Béla",100000 );
        players.add(p1);
        for (int i = 0; i <10 ; i++) {
            oneTurn();
            System.out.println(winnerNumber+"winnerNumber");
            System.out.println(p1.actuelBet);
            System.out.println(p1.getActualCapital());
        }
    }
    public static void oneTurn() {
        for (Player player : players) {
            player.takeABet();
        }
         winnerNumber = spinTheWheel();
        winnersReward();
        losersReward();
/*

        letrejonnek a jateokosok
      ActuallyNotUsedClasses.BelaStrategyPlayer b=  new ActuallyNotUsedClasses.BelaStrategyPlayer();
      Plans.RandomStrategyPlayer r=new Plans.RandomStrategyPlayer();

      Rulet2.Bet b=b.getBet()?????????????????
*/
    }

    public static int spinTheWheel() {
        return 1;//random szam
    }

public static void winnersReward() {
    for (Player player : players) {
        for (int i = 0; i < player.betNumbers.length; i++) {
            if (player.betNumbers[i] == winnerNumber) {
                int reward = player.getActuelBet() * player.winnersMultiplier;
                player.setActualCapital(player.getActualCapital() + reward);
            actualWinners.add(player);
            break;
            }
        }
    }

}

public static void losersReward(){
    for (Player player : players) {
            if (!(actualWinners.contains(player))) {
                player.setActualCapital(player.getActualCapital() - player.actuelBet);
            }
    }
actualWinners=new ArrayList<>();
}
}