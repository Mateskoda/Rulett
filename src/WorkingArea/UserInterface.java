//
//  TODOS
//a beviteli mezoket kezelni, a szimulaciot bedrotozni
//

package WorkingArea;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

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
    int numBet[] = new int[37];
    int betAmount;
    static int startingCapital;

    public UserInterface() {
        this.f.getContentPane().setBackground(Color.GRAY);
        this.myGamePanel1 = this.myGame1();
        this.myGamePanel2 = this.myGame2();
        this.myGamePanel1.setSize(800, 600);
        this.radioButtons = new JPanel();
//        JLabel udv =new JLabel("Üvözöllek a rulett játékban!");
//        JLabel udv2 =new JLabel("Válassz az alábbi menüpontok közül :\n" +
//                 " " +
//                " " +
//                " " +
//                " " +
//                " " +
//                " " +
//                " " +
//                " ");
//
        this.r1 = new JRadioButton("Játszani szeretnék egyet!");
        this.r2 = new JRadioButton("Szimulaciót szeretnék futtatni");
        this.radioButtons.add(this.r1);
        this.radioButtons.add(this.r2);
        f.getContentPane().setBackground(Color.GRAY);
        myGamePanel1 = myGame1();
        myGamePanel2 = myGame2();

        radioButtons = new JPanel();
        r1 = new JRadioButton("játszani szeretnék egyet!");
        r2 = new JRadioButton("szimulaciót szeretnék futtatni");
        radioButtons.add(r1);
        radioButtons.add(r2);
        ButtonGroup bg = new ButtonGroup();
        bg.add(this.r1);
        bg.add(this.r2);
        this.r1.addActionListener(this);
        this.r1.addActionListener(this);
        this.panel = new JPanel();
//        panel.add(udv);
//        udv.setFont(new Font("", Font.PLAIN, 40));
//        panel.add(udv2);
        this.panel.add(this.radioButtons);
        this.f.add(this.panel);
        this.f.setSize(800, 600);
        this.f.setVisible(true);
        bg.add(r1);
        bg.add(r2);
        r1.addActionListener(this);
        r1.addActionListener(this);

        new JLabel("Üvözölük a rulett játékban!");
        panel = new JPanel();
        panel.add(radioButtons);
        f.add(panel);
        panel.add(new JLabel(new ImageIcon("Rulett/src/WorkingArea/rul.png")));
        f.setSize(800, 600);
        f.setResizable(false);
        f.setTitle("Roulete game by MATE & GABOR");
        f.setLocationRelativeTo(null);  //kepernyo kozepere teszi az ablakot
        f.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (r1.isSelected()) {
            f.remove(panel);
            f.add(myGamePanel1);
            f.setVisible(true);
        }
        if (this.r2.isSelected()) {
            RulettApp.userChoosedSimulation();


            //coding here.....................
        }


        if (e.getSource() == submit1) {
            nameOfPlayer = tfname.getText();
            startingCapital = Integer.parseInt(tfstartingCapital.getText());
            f.remove(myGamePanel1);
            f.add(myGamePanel2);
            f.setVisible(true);
        }
        if (e.getSource() == submit2) {
            rangedBet = (String) comboOfBets.getSelectedItem();
            betAmount = Integer.parseInt(tfBetAmount.getText());
            numBet[0] = (Integer) comboNumsOnWheel.getSelectedItem();
            f.setVisible(true);
            RulettApp.userChoosedToPlay();
        }
        if (e.getSource() == btReturn2) {
        }
    }

    public JPanel myGame1() {
        JLabel nameLabel = new JLabel();
        labelPrint=new JLabel();
        nameLabel.setText("Add meg a felhasználó nevedet!");

        JLabel nameLabel2 = new JLabel();
        labelPrint=new JLabel();
        nameLabel2.setText("Add meg a játékra szánt pénzed!");

        tfname = new JTextField("", 20);
       tfstartingCapital = new JTextField("", 10);
        submit1 = new JButton("elküldés");
        tfname = new JTextField("adja meg a nevet!", 20);
        tfstartingCapital = new JTextField("adja meg a játékra szánt pénzét!", 10);

      tfstartingCapital.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                if (!(Character.isDigit(keyEvent.getKeyChar()))) {
                    JOptionPane.showMessageDialog(f, "csak számokat tartalmazzon a mező");
                    f.remove(panel);
                    f.add(myGamePanel1);
                    f.setVisible(true);
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        });
                submit1 = new JButton("elküldés");
        submit1.addActionListener(this);
        btReturn2 = new JButton("vissza");
        myGamePanel1 = new JPanel();
        JPanel tfieldPan = new JPanel();
        tfieldPan.setLayout(new GridLayout(3, 1));
        tfieldPan.add(nameLabel);
        tfieldPan.add(tfname);
        tfieldPan.add(nameLabel2);
        tfieldPan.add(tfstartingCapital);
        myGamePanel1.add(tfieldPan);
        myGamePanel1.add(submit1);
        myGamePanel1.add(btReturn2);
        myGamePanel1.add(new JLabel(new ImageIcon("/home/gabor/IdeaProjects/Rulett/src/WorkingArea/rul.png")));
        return myGamePanel1;
    }

    public JPanel myGame2() {
        JLabel nameLabel = new JLabel();
        labelPrint = new JLabel();
        myGamePanel2 = new JPanel();
        String[] bets = new String[]{"odds", "evens", "highs", "lows", "red", "black"};
        comboOfBets = new JComboBox(bets);
        Integer[] nums = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36};
        comboNumsOnWheel = new JComboBox(nums);
        JPanel gameJPanel = new JPanel();
        submit2 = new JButton("mehet a pörgetés!");
        submit2.addActionListener(this);
        btReturn3 = new JButton("vissza");
        tfBetAmount = new JTextField("mekkora a tét?");

        tfBetAmount.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                if (!(Character.isDigit(keyEvent.getKeyChar()))) {
                    JOptionPane.showMessageDialog(f, "csak számokat tartalmazzon a mező");
                    f.remove(panel);
                    f.add(myGamePanel1);
                    f.setVisible(true);
                }
            }
            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        });

        gameJPanel.setPreferredSize(new Dimension(600, 500));
        nameLabel.setText("Hello, kerem tedd meg a tétedet és a fogadásodat!");
        gameJPanel.add(nameLabel);
        gameJPanel.add(new JLabel("válassz a mezők közül, vagy adj meg egy számot"));
        gameJPanel.add(comboOfBets);
        gameJPanel.add(comboNumsOnWheel);
        myGamePanel2.add(new JLabel(new ImageIcon("/home/gabor/IdeaProjects/Rulett/src/WorkingArea/rul.png")));
        gameJPanel.add(new JLabel("mennyi pézben fogadsz?"));
        gameJPanel.add(tfBetAmount);
        myGamePanel2.add(gameJPanel);
       gameJPanel.add(labelPrint);
        gameJPanel.add(submit2);
        gameJPanel.add(btReturn3);


        return myGamePanel2;
    }

    public int[] getRangedBet() {
        switch(rangedBet){
            case "odds":
            case "black":
                return new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 35, 37};
            case "evens":
                return new int[]{0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36};
            case "highs":
                return new int[]{19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37};
            case "lows":
                return new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
            case"red":
                return new int[]{2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36};
        }
        return null;
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

    public void printResult(int winnerNumber, String name, int bet, int actualCapital, int rewards) {
        labelPrint.setText("<html>Winner number:  " + winnerNumber + "    name:  " + name + " <br/>"+"bet:    " + bet + " actual capital:     " + actualCapital + "   rewards: " + rewards+"</html>");
    }
}
