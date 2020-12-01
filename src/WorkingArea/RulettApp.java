
package WorkingArea;

import java.util.ArrayList;
import java.util.Random;

public class RulettApp {
    static ArrayList<Player> players = new ArrayList();
    static ArrayList<Player> actualWinners = new ArrayList();
    static int winnerNumber;
    static int minBet = 1;
    static UserInterface ui;
    private static int[] expectedNums = new int[37];
    static int[] getRangedBet = new int[0];
    static int actualBet = 0;
    static int maxBet = 10000;
    static Player me;

    public RulettApp() {
    }

    public static void main(String[] args) {
        new RulettApp();
        ui = new UserInterface();
        me = new Player(ui.getNameOfPlayer(), ui.getStartingCapital());

    }

    public static void userChoosedSimulation() {
        players.clear();
        String strategy = ui.getStrategy();
        BelaStrategyPlayer p;
        switch (strategy) {
            case "martingal":
                p = new BelaStrategyPlayer(ui.getNameOfPlayer2(), ui.getStartingCapital2(), 0.5);
                System.out.println(ui.getStartingCapital() + "fdfdfdfdfdfdfdf");
                getRangedBet = new int[]{1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 28, 29, 31, 33, 35};
                players.add(p);
                break;
        }
        simulateXTurnForSimulation(ui.getNumOfRounds());
    }

    public static void userChoosedToPlay() {
        players.clear();
        expectedNums = ui.getNumBet();
        actualBet = ui.getBetAmount();
        if (expectedNums.length == 1) {                      //ha egy szamra fogadunk akkor egy egy elemu int tombot adunk at a setbetnumbers()nek
            me.setBetNumbers(ui.getRangedBet());
        } else {
            me.setBetNumbers(expectedNums);         //egy tombot agunk at ha tobb mezore fogadunk
        }
        me.setActuelBet(actualBet);
        players.clear();
        players.add(me);

        simulateXTurn(1);
        int sum = ui.getStartingCapital();
        ui.printResult(winnerNumber, ui.getNameOfPlayer(), me.getActuelBet(), sum + me.getActualCapital(), me.getActualCapital());
    }

    public static void simulateXTurn(int x) {
        for (int i = 0; i < x; ++i) {
            oneTurn();
        }
    }

    public static void simulateXTurnForSimulation(int x) {
        for (int i = 0; i < x; ++i) {
            oneTurnSimulation();
            for (Player p : players) {
                ui.printResultforTextarea(winnerNumber, p.getName(), p.getActuelBet(), p.getActualCapital(), p.getActualCapital() - p.getStartingCapital());
            }
        }
    }

    public static void oneTurn() {
        for (int i = 0; i < players.size(); i++) {
            players.get(i).takeABet();
        }
        winnerNumber = spinTheWheel();
        winnersReward();
        losersReward();
    }

    public static void oneTurnSimulation() {
        for (int i = 0; i < players.size(); i++) {
            players.get(i).takeABet();
        }
        winnerNumber = spinTheWheel();
        winnersRewardSimulation();
        losersReward();
    }

    public static int spinTheWheel() {
        return (new Random()).nextInt(37);
    }

    public static void winnersReward() {
        int sum;
        for (Player p : players) {
            for (int i = 0; i < ui.getRangedBet().length; i++) {/////at kell adni a jateokosnak is
                if (ui.getRangedBet()[i] == winnerNumber) {
                    actualWinners.add(p);
                    if (ui.getRangedBet().length != 1) {
                        sum = p.getActualCapital() + p.getActuelBet();
                    } else {
                        sum = p.getActualCapital() + p.getActuelBet() * 5;
                    }
                    p.setActualCapital(sum);
                    break;
                }
            }
        }
    }

    public static void winnersRewardSimulation() {
        int sum2;
        for (Player p : players) {
            for (int i = 0; i < getRangedBet.length; i++) {/////at kell adni a jateokosnak is

                if (getRangedBet[i] == winnerNumber) {
                    actualWinners.add(p);
                    if (getRangedBet.length != 1) {
                        sum2 = p.getActualCapital() + p.getActuelBet();
                    } else {
                        sum2 = p.getActualCapital() + p.getActuelBet() * 5;
                    }
                    p.setActualCapital(sum2);
                    break;
                }
            }
        }
    }


    public static void losersReward() {
        for (Player player : players) {
            if (!(actualWinners.contains(player))) {
                player.setActualCapital(player.getActualCapital() - player.getActuelBet());
                break;
            }
        }
        actualWinners.clear();
    }

    public int getMinBet() {
        return minBet;
    }

    public static int getMaxBet() {
        return maxBet;
    }
}
