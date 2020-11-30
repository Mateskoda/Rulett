package RulettTerminal;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RulettApp {
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
    static int maxBet = 10000;

    public static void main(String[] args) {
        System.out.println(Bet.RED);
            RulettApp rp = new RulettApp();
UserInterface userInterface = new UserInterface();

        System.out.println("Játszani akarsz, vagy szimulációt indítani ( j / sz) !");
//        exeptiont lekezelni
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        if (answer.equals("sz")) {
//            userChoosedSimulation();
        } else if (answer.equals("j")) {
//            userChoosedToPlay();
            // if I want to play:
            Me me = new Me();
                players.removeAll(players);         //in case of simulation was runned before, and "players has already items in it......"
                players.add(me);
                rp.simulateXTurn(1);

            }

        }


    public  void userChoosedSimulation() {
        Scanner sc = new Scanner(System.in);
        String answer;
        System.out.println("Add meg ,hány kört szimuláljunk");
        int x = Integer.parseInt(sc.nextLine());
//        exeptiont lekezelni
//<<<<<<< HEAD
        System.out.println("Add meg ,milyen stratégiát szeretnél használni ( pl. martingal,random)");
        String strategy = sc.nextLine();
        if (strategy.equals("martingal")) {
            BelaStrategyPlayer p1 = new BelaStrategyPlayer("BélaMinBet", 100000, 0.5);
            BelaStrategyPlayer p2 = new BelaStrategyPlayer("BélaMaxBet", 100000, 10000);
            players.add(p1);
            players.add(p2);
        } else if (strategy.equals("random")) {
            RandomColorStrategyPlayer p1 = new RandomColorStrategyPlayer("RandomBet", 100000);
            players.add(p1);
        }
        simulateXTurn(x);
    }
//=======



//       simulate10Turn();
//        simulate100Turn();
//>>>>>>> 0e55d2bad7e58bca6c59521c9c706933280a3731

//    public static void userChoosedToPlay() {
//        Scanner sc = new Scanner(System.in);
//        String answer;
//        boolean endTheGame = false;
//        System.out.println("Add meg ,mekkora kezdőértékkel indulsz");
//        int startingCapital = Integer.parseInt(sc.nextLine());
//        while (!endTheGame) {
//            System.out.println("Add meg ,hogy ebben a körben mire fogadsz( pl. red)");
//            String betName = sc.nextLine();
//            System.out.println("Add meg ,mekkora összeget teszel fel");
//            int actualBet = Integer.parseInt(sc.nextLine());
//            if (players.isEmpty()){
//            UserPlayer p1 = new UserPlayer("User", startingCapital, betName, actualBet);
//            players.add(p1);}
//            ((UserPlayer)players.get(0)).setBet(actualBet);
//            ((UserPlayer)players.get(0)).setBetName(betName);
//    //        simulateXTurn(1);

//        boolean rightAnswer = false;
//        while (rightAnswer==false) {
//            System.out.println("Játszol tovább ? (i/n)");
//            answer = sc.nextLine();
//            if (answer.equals("i")) {
//                endTheGame = false;
//                rightAnswer = true;
//            } else if (answer.equals("n")) {
//                endTheGame = true;
//                rightAnswer = true;
//            } else {
//                System.out.println("helytelen karakter. a helyes karakterválaszok i vagy n .");
//            }
//        }}
//    }

    public void simulateXTurn(int x) {               //runs the oneTurn() method x times
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

    public void simulate10Turn() {
        for (int i = 0; i < 10; i++) {
            oneTurn();
            System.out.println("winnerNumber :" + winnerNumber);
            for (Player player : players) {
                System.out.println(player.getActuelBet());
                System.out.println(player.getActualCapital());
            }
        }
    }

    public void simulate100Turn() {
        for (int i = 0; i < 100; i++) {
            oneTurn();
            System.out.println(winnerNumber + "winnerNumber");
            for (Player player : players) {
                System.out.println(player.getActuelBet());
                System.out.println(player.getActualCapital());
            }
        }
    }

    public void oneTurn() {
        for (Player player : players) {
            player.takeABet();
        }
        winnerNumber = spinTheWheel();
        winnersReward();
        losersReward();
/*

        letrejonnek a jateokosok
      ActuallyNotUsedClasses.BelaStrategyPlayer b=  new ActuallyNotUsedClasses.BelaStrategyPlayer();
      WorkingArea.RandomStrategyPlayer r=new WorkingArea.RandomStrategyPlayer();

      Rulet2.Bet b=b.getBet()?????????????????
*/
    }

    public int spinTheWheel() {
        return new Random().nextInt(37);//random szam
    }

    public void winnersReward() {
        for (Player player : players) {
            for (int i = 0; i < player.getBetNumbers().length; i++) {
                if (player.getBetNumbers()[i] == winnerNumber) {
                    int reward = player.getActuelBet() * player.getWinnersMultiplier();
                    player.setPreviousTurnCapital(player.getActualCapital());
                    player.setActualCapital(player.getActualCapital() + reward);
                    actualWinners.add(player);
                    System.out.println(player.getName()+" is a winner this time. ");
                    break;
                }
            }
        }

    }

    public void losersReward() {
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

    public int getMinBet() {
        return minBet;
    }

    public static int getMaxBet() {
        return maxBet;
    }
}