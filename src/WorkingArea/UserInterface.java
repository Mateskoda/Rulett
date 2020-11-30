//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package WorkingArea;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class UserInterface extends JFrame implements ActionListener {
    JRadioButton r1;
    JRadioButton r2;
    JFrame f = new JFrame();
    JPanel radioButtons;
    JPanel myGamePanel1;
    JPanel myGamePanel2;
    JPanel panel;
    JTextField tfname;
    JTextField tfstartingCapital;
    JTextField tfBetAmount;
    JButton submit1;
    JButton submit2;
    JButton btReturn2;
    JButton btReturn3;
    JLabel labelPrint;
    JComboBox comboOfBets;
    JComboBox comboNumsOnWheel;
    static String nameOfPlayer = "";
    String rangedBet;
    int numBet[]=new int[37];
    int betAmount;
    static int startingCapital;

    public UserInterface() {
        this.f.getContentPane().setBackground(Color.GRAY);
        this.myGamePanel1 = this.myGame1();
        this.myGamePanel2 = this.myGame2();
        this.myGamePanel1.setSize(800, 600);
        this.radioButtons = new JPanel();
        this.r1 = new JRadioButton("szimulaciót szeretnék futtatni");
        this.r2 = new JRadioButton("játszani szeretnék egyet!");
        this.radioButtons.add(this.r1);
        this.radioButtons.add(this.r2);
        ButtonGroup bg = new ButtonGroup();
        bg.add(this.r1);
        bg.add(this.r2);
        this.r1.addActionListener(this);
        this.r1.addActionListener(this);
        new JLabel("Üvözölük a rulett játékban!");
        this.panel = new JPanel();
        this.panel.add(this.radioButtons);
        this.f.add(this.panel);
        this.f.setSize(800, 600);
        this.f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (this.r1.isSelected()) {
            this.f.remove(this.panel);
            this.f.add(this.myGamePanel1);
            this.f.setVisible(true);
        }

        if (this.r2.isSelected()) {
            RulettApp.userChoosedSimulation();
        }

        if (e.getSource() == submit1) {
            System.out.println(tfname.getText());
            nameOfPlayer = tfname.getText();
            System.out.println(tfstartingCapital.getText());
            startingCapital = Integer.parseInt(tfstartingCapital.getText());
            f.remove(myGamePanel1);
            f.add(myGamePanel2);
            f.setVisible(true);
        }



        if (e.getSource() == this.submit2) {
            this.rangedBet = (String)this.comboOfBets.getSelectedItem();
            this.betAmount = Integer.parseInt(this.tfBetAmount.getText());
            numBet[0]= (Integer)this.comboNumsOnWheel.getSelectedItem();
            RulettApp.userChoosedToPlay();
            System.out.println(this.numBet);
            this.f.setVisible(true);
        }

        if (e.getSource() == this.btReturn2) {
        }

    }

    public JPanel myGame1() {
        tfname = new JTextField("adja meg a nevet!", 20);
       tfstartingCapital = new JTextField("adja meg a játékra szánt pénzét!", 10);
        submit1 = new JButton("elküldés");
        submit1.addActionListener(this);
        btReturn2 = new JButton("vissza");
        myGamePanel1 = new JPanel();
        JPanel tfieldPan = new JPanel();
        tfieldPan.setLayout(new GridLayout(3, 1));
        tfieldPan.add(tfname);
        tfieldPan.add(tfstartingCapital);
        myGamePanel1.add(tfieldPan);
        myGamePanel1.add(submit1);
        myGamePanel1.add(btReturn2);
        return myGamePanel1;
    }

    public JPanel myGame2() {
        JLabel nameLabel = new JLabel();
        labelPrint=new JLabel();
        myGamePanel2 = new JPanel();
        String[] bets = new String[]{"odds", "evens", "highs", "lows", "red", "black"};
        comboOfBets = new JComboBox(bets);
        Integer[] nums = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36};
        comboNumsOnWheel = new JComboBox(nums);
        JPanel gamePan = new JPanel();
        submit2 = new JButton("mehet a pörgetés!");
        submit2.addActionListener(this);
        btReturn3 = new JButton("vissza");
        tfBetAmount = new JTextField("mekkora a tét?");
        gamePan.setPreferredSize(new Dimension(600, 500));
        nameLabel.setText("Hello kedves " + nameOfPlayer + " kerem tedd meg a tétedet és a fogadásodat!");
        gamePan.add(nameLabel);
        gamePan.add(new JLabel("válassz a mezők közül, vagy adj meg egy számot"));
        gamePan.add(comboOfBets);
        gamePan.add(comboNumsOnWheel);
        gamePan.add(new JLabel("mennyi pézben fogadsz?"));
        gamePan.add(tfBetAmount);
        myGamePanel2.add(gamePan);
        myGamePanel2.add(submit2);
        myGamePanel2.add(labelPrint);
        myGamePanel2.add(btReturn3);
        return myGamePanel2;
    }

    public int[] getRangedBet() {

        if(rangedBet.equals("odds")){

            return new int[]{1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,35,37};

       //////////////////////to work out here

        }return null;
    }

    public Integer getBetAmount() {
        return this.betAmount;
    }

    public int[] getNumBet() {
        return numBet;
    }

    public String getNameOfPlayer() {
        return nameOfPlayer;
    }

    public int getStartingCapital() {
        return startingCapital;
    }

    public  void printResult(int winnerNumber, String name,int bet, int actualCapital, int rewards){

        labelPrint.setText("Winner number:  "+winnerNumber+"    name:  "+name+" actual capital:     "+actualCapital+"   rewards: "+rewards);

    }
}
