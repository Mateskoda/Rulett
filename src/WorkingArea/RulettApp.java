//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


/*
elvileg nem szamitja ki az actual capital, sum rewards ertekekt, ugy tunik hogy csak vesziteni tud........de azt jol
csak az odds okra mukodik eddig
        a userinterface vegen lehet beadni a mezonyeremenyeket reprezentalo tomboket
*/



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
        me=new Player("",0);
    }

    public static void userChoosedSimulation() {
    }

    public static void userChoosedToPlay() {
        expectedNums =ui.getNumBet();
        actualBet=ui.getBetAmount();
        ui.getRangedBet();


        if(me.getName()==null){
            me=new Player(ui.getNameOfPlayer(),ui.getStartingCapital());
            System.out.println("wewwewewewe");
        }

        //itt kell megadni a fogadasi szamokat egy tombben

        if(expectedNums.length==0){                      //ha egy szamra fogadunk akkor egy egy elemu int tombot adunk at a setbetnumbers()nek
            me.setBetNumbers(ui.getRangedBet());
        }
        else{
            me.setBetNumbers(expectedNums);         //egy tombot agunk at ha tobb mezore fogadunk
        }
        me.setActuelBet(actualBet);  //tet osszege
        players.clear();
        players.add(me);
        //a simulate xturnnek kell:
        simulateXTurn(1);
    }

    public static void simulateXTurn(int x) {
        for(int i = 0; i < x; ++i) {
            oneTurn();
            System.out.println("winnerNumber :" + winnerNumber);
            Iterator var2 = players.iterator();

            while(var2.hasNext()) {


                Player player = (Player)var2.next();
                int sumOfRewards=player.getActualCapital() - player.getStartingCapital();
                ui.printResult(winnerNumber,player.getName(),player.getActuelBet(),player.getActualCapital(),sumOfRewards);



               // System.out.println("Name " + );
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
      for(Player p:players){
          for(int i=0;i<p.getBetNumbers().length;i++){
              if(p.getBetNumbers()[i]==winnerNumber){
                  int reward=p.getActualCapital()*p.getWinnersMultiplier();
                  p.setActualCapital(p.getActualCapital()+reward);
                  actualWinners.add(p);
                  break;
              }
          }
      }
    }


// hol teszi bele a gyoztest az actualwinnerbe

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
