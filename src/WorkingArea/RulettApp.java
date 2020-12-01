
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
    static int[] getRangedBet=new int[0];
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
           String strategy= ui.getStrategy();

           switch(strategy) {
               case "martingal":
                   BelaStrategyPlayer p=new BelaStrategyPlayer(ui.getNameOfPlayer(),ui.getStartingCapital(),0.5);

                   getRangedBet=new int[]{1,2,3,4};
                   players.add(p);

                   break;
           }
        System.out.println(ui.getNumOfRounds());
        simulateXTurnForSimulation(ui.getNumOfRounds());
        //int sum = ui.getStartingCapital();
        //ui.printResult(winnerNumber, ui.getNameOfPlayer(), me.getActuelBet(), sum + me.getActualCapital(), me.getActualCapital());
        players.clear();

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
        me.setActuelBet(actualBet);  //tet osszege
        players.clear();
        players.add(me);

        simulateXTurn(1);
        int sum = ui.getStartingCapital();
        ui.printResult(winnerNumber, ui.getNameOfPlayer(), me.getActuelBet(), sum + me.getActualCapital(), me.getActualCapital());
        //ui.printResult(winnerNumber,players.get(0).getName(),players.get(0).getActuelBet(),players.get(0).getSumOfRewards(),players.get(0).getActualCapital());

    }



   /* public static void userChoosedToPlay() {

        expectedNums = ui.getNumBet();
        actualBet = ui.getBetAmount();
        if (expectedNums.length == 1) {                      //ha egy szamra fogadunk akkor egy egy elemu int tombot adunk at a setbetnumbers()nek
            me.setBetNumbers(ui.getRangedBet());
        } else {
            me.setBetNumbers(expectedNums);         //egy tombot agunk at ha tobb mezore fogadunk
        }
        me.setActuelBet(actualBet);  //tet osszege
        players.clear();
        players.add(me);

        simulateXTurn(1);
        int sum = me.getActualCapital();

        ui.printResult(winnerNumber, ui.getNameOfPlayer(), me.getActuelBet(), sum + me.getActualCapital(), sum);
        //ui.printResult(winnerNumber,players.get(0).getName(),players.get(0).getActuelBet(),players.get(0).getSumOfRewards(),players.get(0).getActualCapital());
        players.clear();
    }*/

    public static void simulateXTurn(int x) {
        for (int i = 0; i < x; ++i) {
            oneTurn();
        }
    }


    public static void simulateXTurnForSimulation(int x) {
        for (int i = 0; i < x; ++i) {
            oneTurnSimulation();


            System.out.println(winnerNumber);
            for(Player p:players){
               int reward=p.getActualCapital()-p.getStartingCapital();
                ui.printResultforTextarea(winnerNumber, p.getName(), p.getActuelBet(),p.getActualCapital(),reward);
                System.out.println(p.getName()+"name");
                System.out.println(p.getActuelBet()+"actbet");
                System.out.println(p.getActualCapital()+"actcapital");
                System.out.println(p.getActualCapital()-p.getStartingCapital());
                System.out.println();

            }

            }
            System.out.println();
        }



    public static void oneTurn() {
        for(int i=0;i<players.size();i++){
            players.get(i).takeABet();
        }
        winnerNumber = spinTheWheel();
        winnersReward();
        losersReward();
        //System.out.println(players.get(0).getActualCapital());
    }

    public static void oneTurnSimulation() {
        for(int i=0;i<players.size();i++){
            players.get(i).takeABet();
        }
        winnerNumber = spinTheWheel();
        winnersRewardSimulation();
        losersReward();
        //System.out.println(players.get(0).getActualCapital());
    }

    public static int spinTheWheel() {
        return (new Random()).nextInt(37);
    }

    public static void winnersReward() {
        int sum;
        for (Player p : players) {
            for (int i = 0; i < ui.getRangedBet().length; i++) {/////at kell adni a jateokosnak is
                System.out.println(ui.getRangedBet()[i]);
                if (ui.getRangedBet()[i]== winnerNumber) {
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

    public static void winnersRewardSimulation() {
        int sum;
        for (Player p : players) {
            for (int i = 0; i < getRangedBet.length; i++) {/////at kell adni a jateokosnak is
                System.out.println(getRangedBet[i]);
                if (getRangedBet[i]== winnerNumber) {
                    actualWinners.add(p);

                    if(getRangedBet.length!=1){
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
