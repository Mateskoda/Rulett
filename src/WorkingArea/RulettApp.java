//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package WorkingArea;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class RulettApp {
    static ArrayList<Player> players = new ArrayList();
    static ArrayList<Player> actualWinners = new ArrayList();
    static int winnerNumber;
    static int minBet = 1;
    static UserInterface ui;
    private static Integer expectedNum = 0;
    static int actualBet = 0;
    static int maxBet = 10000;

    public RulettApp() {
    }

    public static void main(String[] args) {
        new RulettApp();
        ui = new UserInterface();
    }

    public static void userChoosedSimulation() {
    }

    public static void userChoosedToPlay() {
        ui.getNumBet();
        System.out.println(ui.getBetAmount() + "dfdfdfdfd");
        simulateXTurn(1);
    }

    public static void simulateXTurn(int x) {
        for(int i = 0; i < x; ++i) {
            oneTurn();
            System.out.println("winnerNumber :" + winnerNumber);
            Iterator var2 = players.iterator();

            while(var2.hasNext()) {
                Player player = (Player)var2.next();
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
        for(int i = 0; i < 10; ++i) {
            oneTurn();
            System.out.println("winnerNumber :" + winnerNumber);
            Iterator var2 = players.iterator();

            while(var2.hasNext()) {
                Player player = (Player)var2.next();
                System.out.println(player.getActuelBet());
                System.out.println(player.getActualCapital());
            }
        }

    }

    public void simulate100Turn() {
        for(int i = 0; i < 100; ++i) {
            oneTurn();
            System.out.println(winnerNumber + "winnerNumber");
            Iterator var2 = players.iterator();

            while(var2.hasNext()) {
                Player player = (Player)var2.next();
                System.out.println(player.getActuelBet());
                System.out.println(player.getActualCapital());
            }
        }

    }

    public static void oneTurn() {
        Iterator var0 = players.iterator();

        while(var0.hasNext()) {
            Player player = (Player)var0.next();
            player.takeABet();
        }

        winnerNumber = spinTheWheel();
        winnersReward();
        losersReward();
    }

    public static int spinTheWheel() {
        return (new Random()).nextInt(37);
    }

    public static void winnersReward() {
        Iterator var0 = players.iterator();

        while(true) {
            while(var0.hasNext()) {
                Player player = (Player)var0.next();

                for(int i = 0; i < player.getBetNumbers().length; ++i) {
                    if (player.getBetNumbers()[i] == winnerNumber) {
                        int reward = player.getActuelBet() * player.getWinnersMultiplier();
                        player.setPreviousTurnCapital(player.getActualCapital());
                        player.setActualCapital(player.getActualCapital() + reward);
                        System.out.println(player.getName() + " is a winner this time. ");
                        break;
                    }
                }
            }

            return;
        }
    }

    public static void losersReward() {
        Iterator var0 = players.iterator();

        while(var0.hasNext()) {
            Player player = (Player)var0.next();
            if (!actualWinners.contains(player)) {
                player.setActualCapital(player.getActualCapital() - player.getActuelBet());
                int i = player.getActualCapital();
                double pr = player.getPreviousBet();
                int j = player.getActuelBet();
                boolean var6 = true;
            }
        }

        actualWinners = new ArrayList();
    }

    public int getMinBet() {
        return minBet;
    }

    public static int getMaxBet() {
        return maxBet;
    }
}
