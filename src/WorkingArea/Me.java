/*
*  This class extends from Player. It allows us to play a game instead of simulations.
* We have to register by name and with a starter amount. This amount is already checked for valid data.
* To place a bet is already possible,but have to work out the winner nums
*
* Me class is connecting to the object and class structure of the program. Following the conceptes and using the player
* class and the RulettApps class fields and methods.
* */


package WorkingArea;

import WorkingArea.RulettApp;

import java.util.Scanner;

public class Me extends Player{
    private String name;
    private int startingCapital;
    private int actualCapital;
    private int bet=1;

    public Me() {
        super("me",1);                          //should use this temprary 4 inheritance
        Scanner sc=new Scanner(System.in);
        System.out.println();
        System.out.println("kérem add meg a nevedet!");
        name=sc.nextLine();
        System.out.println("Mennyi a kezdőpénzed, amivel játszol??");
        do{
            startingCapital=sc.nextInt();
            if(startingCapital >RulettApp.getMaxBet()){
                System.out.println("a kezdő összeged nem lehet nagyobb a megengedett maximális tétnél, ami :"+RulettApp.getMaxBet());
                System.out.println("kérek egy új számot!");
            }
        }
        while(startingCapital>RulettApp.getMaxBet());

        super.setName(name);
        super.setActualCapital(startingCapital);

        System.out.println("kerem tegyen tétet!");
        do{
            bet=sc.nextInt();
            if(bet>RulettApp.getMaxBet() || bet>startingCapital){
                System.out.println("ez a tét nem tehető ki,mert vagy nincs fedezete rá, vagy magasabb a maximális tétnél..:"+RulettApp.getMaxBet());
                System.out.println("kérek egy új tétet!");
            }
        }

       //TO BE CONtINUED HERE...........................................
        while(startingCapital>RulettApp.getMaxBet());
          System.out.println("mire fogadsz?         >>>>most meg gyarilag a 4, 6 van beegetve");



    }

    @Override
    public void takeABet() {
        setActuelBet(bet);
        setBetNumbers(new int[]{4,6});                      //need to work out (the bets colors numbers odd......)
    }
}
