package WorkingArea;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RulettApp {
    //
    static ArrayList<Player> players = new ArrayList<>();
    static ArrayList<Player> actualWinners = new ArrayList<>();
    static int winnerNumber;
    static int minBet = 1;

    //    So...
//      In the main we create the list players.
//    In one turn players take their bets;
//    After we spin the wheel and get the winnernumber.
//    If the player wins, his Capital will grow,
//    otherwise he will lose his bet(money).
//        System.out.println();
    static int maxBet = 10000;

    public static void main(String[] args) {
        RulettApp rp = new RulettApp();

        System.out.println("Játszani akarsz, vagy szimulációt indítani ( j / sz) !");
//        exeptiont lekezelni
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        if (answer.equals("sz")) {
            System.out.println("Add meg ,hány kört szimuláljunk");
            int x = Integer.parseInt(sc.nextLine());
//        exeptiont lekezelni
            System.out.println("Add meg ,milyen stratégiát szeretnél használni ( pl. martingal)");
            String strategy = sc.nextLine();
            if (strategy.equals("martingal")) {
                BelaStrategyPlayer p1 = new BelaStrategyPlayer("BélaMinBet", 100000, 0.5);
                BelaStrategyPlayer p2 = new BelaStrategyPlayer("BélaMaxBet", 100000, 10000);
                players.add(p1);
                players.add(p2);
            }
            simulateXTurn(x);
        }
//       simulate10Turn();
//        simulate100Turn();

    }

    public static void simulateXTurn(int x) {
        for (int i = 0; i < x; i++) {
            oneTurn();
            System.out.println("winnerNumber :" + winnerNumber);
            for (Player player : players) {
                System.out.println("Name " + player.getName());
                System.out.println("ActuelBet " + player.getActuelBet());
                System.out.println("ActualCapital " + player.getActualCapital());
                System.out.println("SumOfRewards " + (player.getActualCapital() - player.getStartingCapital()));
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void simulate10Turn() {
        for (int i = 0; i < 10; i++) {
            oneTurn();
            System.out.println("winnerNumber :" + winnerNumber);
            for (Player player : players) {
                System.out.println(player.getActuelBet());
                System.out.println(player.getActualCapital());
            }
        }
    }

    public static void simulate100Turn() {
        for (int i = 0; i < 100; i++) {
            oneTurn();
            System.out.println(winnerNumber + "winnerNumber");
            for (Player player : players) {
                System.out.println(player.getActuelBet());
                System.out.println(player.getActualCapital());
            }
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
        return new Random().nextInt(37);//random szam
    }

    public static void winnersReward() {
        for (Player player : players) {
            for (int i = 0; i < player.getBetNumbers().length; i++) {
                if (player.getBetNumbers()[i] == winnerNumber) {
                    int reward = player.getActuelBet() * player.getWinnersMultiplier();
                    player.setPreviousTurnCapital(player.getActualCapital());
                    player.setActualCapital(player.getActualCapital() + reward);
                    actualWinners.add(player);
                    break;
                }
            }
        }

    }

    public static void losersReward() {
        for (Player player : players) {
            if (!(actualWinners.contains(player))) {
                player.setActualCapital(player.getActualCapital() - player.getActuelBet());
                int i = player.getActualCapital();
                double pr = player.getPreviousBet();
                int j = player.getActuelBet();
                int k = 1;
            }
        }
        actualWinners = new ArrayList<>();
    }

    public static int getMinBet() {
        return minBet;
    }

    public static int getMaxBet() {
        return maxBet;
    }
}