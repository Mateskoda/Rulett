
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
    private static int[] expectedNums = new int[37];
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




    }

    public static void userChoosedToPlay() {
        expectedNums = ui.getNumBet();
        actualBet = ui.getBetAmount();
        if (expectedNums.length == 0) {                      //ha egy szamra fogadunk akkor egy egy elemu int tombot adunk at a setbetnumbers()nek
            me.setBetNumbers(ui.getRangedBet());
        } else {
            me.setBetNumbers(expectedNums);         //egy tombot agunk at ha tobb mezore fogadunk
        }
        me.setActuelBet(actualBet);  //tet osszege
        players.clear();
        players.add(me);

        simulateXTurn(1);
        int sum = ui.getStartingCapital();
        ui.printResult(winnerNumber, ui.getNameOfPlayer(), me.getActuelBet(), sum + me.getActualCapital(), me.getActualCapital());
        players.clear();
    }

    public static void simulateXTurn(int x) {
        for (int i = 0; i < x; ++i) {
            oneTurn();
        }
    }


    public void simulate10Turn() {
        for (int i = 0; i < 10; ++i) {
            oneTurn();
            System.out.println("winnerNumber :" + winnerNumber);
            Iterator var2 = players.iterator();

            while (var2.hasNext()) {
                Player player = (Player) var2.next();
                System.out.println(player.getActuelBet());
                System.out.println(player.getActualCapital());
            }
        }
    }

    public void simulate100Turn() {
        for (int i = 0; i < 100; ++i) {
            oneTurn();
            System.out.println(winnerNumber + "winnerNumber");
            Iterator var2 = players.iterator();

            while (var2.hasNext()) {
                Player player = (Player) var2.next();
                System.out.println(player.getActuelBet());
                System.out.println(player.getActualCapital());
            }
        }
    }

    public static void oneTurn() {
        Iterator var0 = players.iterator();

        while (var0.hasNext()) {
            Player player = (Player) var0.next();
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
        int sum;
        for (Player p : players) {
            for (int i = 0; i < ui.getRangedBet().length; i++) {
                if (ui.getRangedBet()[i] == winnerNumber) {
                    actualWinners.add(p);
                    if(ui.getRangedBet().length!=1){
                        sum = p.getActualCapital() + p.getActuelBet();
                    }
                    else{
                        sum=p.getActualCapital() + p.getActuelBet()*5;
                    }
                    p.setActualCapital(sum);
                    break;
                }
            }
        }
    }

    public static void losersReward() {
        for (Player player : players) {
            if (!(actualWinners.contains(player))) {
                player.setActualCapital(player.getActualCapital() - player.getActuelBet());
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
