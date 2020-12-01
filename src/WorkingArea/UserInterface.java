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
    JPanel myGamePanel3;
    JPanel panel;
    JTextField tfname;
    JTextField tfname2;
    JTextField tfstartingCapital;
    JTextField tfstartingCapital2;
    JTextField tfBetAmount;
    JTextField tfNumOfRounds;
    JTextArea textArea;
    JButton submit1;
    JButton submit2;
    JButton submit3;
    JButton btReturn2;
    JButton btReturn3;
    JLabel labelPrint;
    JComboBox comboOfBets;
    JComboBox comboOfStrategy;
    JComboBox comboNumsOnWheel;
    String nameOfPlayer;
    String nameOfPlayer2;
    String strategy;
    Bet rangedBet;
    int numBet[] = new int[37];
    int betAmount;
    int startingCapital;
    int startingCapital2;
    int numOfRounds;

    public UserInterface() {
        f.getContentPane().setBackground(Color.GRAY);
        myGamePanel1 = myGame1();
        myGamePanel2 = myGame2();
        myGamePanel3 = myGame3();

        radioButtons = new JPanel();
        r1 = new JRadioButton("játszani szeretnék egyet!");
        r2 = new JRadioButton("szimulaciót szeretnék futtatni");
        radioButtons.add(r1);
        radioButtons.add(r2);
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        r1.addActionListener(this);
        r2.addActionListener(this);

        new JLabel("Üvözölük a rulett játékban!");
        panel = new JPanel();
        panel.add(radioButtons);
        f.add(panel);
        panel.add(new JLabel(new ImageIcon("/home/gabor/IdeaProjects/Rulett/src/WorkingArea/rul.png")));
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
        if (r2.isSelected()) {

            f.remove(panel);
            f.add(myGamePanel3);
            f.setVisible(true);

            //coding here.....................
        }


        if (e.getSource() == submit1) {
            nameOfPlayer = tfname.getText();
            System.out.println(nameOfPlayer);
            startingCapital = Integer.parseInt(tfstartingCapital.getText());
            f.remove(myGamePanel1);
            f.add(myGamePanel2);
            f.setVisible(true);
        }
        if (e.getSource() == submit2) {
            rangedBet = (Bet) (comboOfBets.getSelectedItem());
            betAmount = Integer.parseInt(tfBetAmount.getText());
            numBet[0] = (Integer) comboNumsOnWheel.getSelectedItem();
            f.setVisible(true);
            RulettApp.userChoosedToPlay();
        }
        if (e.getSource() == submit3) {
            strategy = (String) comboOfStrategy.getSelectedItem();
            numOfRounds = Integer.parseInt(tfNumOfRounds.getText());
            startingCapital2=Integer.parseInt(tfstartingCapital2.getText());
            nameOfPlayer2=tfname2.getText();
            RulettApp.userChoosedSimulation();
        }
    }

    public JPanel myGame1() {       //user player elso ablak
        JLabel nameLabel = new JLabel();
        labelPrint = new JLabel();
        nameLabel.setText("Add meg a felhasználó nevedet!");

        JLabel nameLabel2 = new JLabel();
        labelPrint = new JLabel();
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
                    tfstartingCapital.setText("");
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        });

        submit1 = new JButton("szeretem a mézet:)");
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

    public JPanel myGame2() {//userolayer 2 ablak
        JLabel nameLabel = new JLabel();
        labelPrint = new JLabel();
        myGamePanel2 = new JPanel();
        Bet[] bets = new Bet[]{Bet.TOP_LINE, Bet.FIRST_COLUMN, Bet.SECOND_COLUMN, Bet.THIRD_COLUMN, Bet.FIRST_DOZEN,
                Bet.SECOND_DOZEN, Bet.THIRD_DOZEN, Bet.ONE_TO_EIGHTTEEN, Bet.NINETEEN_TO_THIRTYSIX, Bet.ODD, Bet.EVEN
                , Bet.RED, Bet.BLACK, Bet.LOW, Bet.HIGH, Bet.STRAIGHT_UP, Bet.STREET, Bet.CORNER, Bet.SIX_LINE};
        comboOfBets = new JComboBox(bets);
        Integer[] nums = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36};
        comboNumsOnWheel = new JComboBox(nums);
        JPanel gameJPanel = new JPanel();
        submit2 = new JButton("tovább");
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


    public JPanel myGame3() {

        // jlabel a kiirashoz

        textArea = new JTextArea();

        tfname2 = new JTextField("adja meg a nevet!", 20);
        tfNumOfRounds = new JTextField("adja meg a körök számát!", 10);
        tfstartingCapital2 = new JTextField("adja meg a kezdő tőkét!", 10);
        String[] nameOfStrat = {"martingal", "random"};
        comboOfStrategy = new JComboBox(nameOfStrat);
        tfNumOfRounds.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                if (!(Character.isDigit(keyEvent.getKeyChar()))) {
                    JOptionPane.showMessageDialog(f, "csak számokat tartalmazzon a mező");
                   /* f.remove(myGamePanel1);
                    f.add(myGamePanel1);
                    f.setVisible(true);*/
                    tfNumOfRounds.setText("");
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        });
        submit3 = new JButton("mehet");
        submit3.addActionListener(this);
        btReturn2 = new JButton("vissza");
        myGamePanel3 = new JPanel();
        JPanel tfieldPan = new JPanel();
        tfieldPan.setLayout(new GridLayout(3, 1));
        tfieldPan.add(tfname2);
        tfieldPan.add(comboOfStrategy);
        tfieldPan.add(tfNumOfRounds);
        tfieldPan.add(tfstartingCapital2);
        myGamePanel3.add(tfieldPan);
        myGamePanel3.add(submit3);
        myGamePanel3.add(btReturn2);
        //myGamePanel3.add(new JLabel(new ImageIcon("/home/gabor/IdeaProjects/Rulett/src/WorkingArea/rul.png")));
        myGamePanel3.add(textArea);

        return myGamePanel3;
    }


    public int[] getRangedBet() {
        if (rangedBet == Bet.BLACK) {
            return new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 35, 37};
        } else if (rangedBet == Bet.CORNER) {
            return new int[]{0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36};
        } else if (rangedBet == Bet.EVEN) {
            return new int[]{19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37};
        } else if (rangedBet == Bet.FIRST_COLUMN) {
            return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
        } else if (rangedBet == Bet.FIRST_COLUMN) {
            return new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36};
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

    public int getNumOfRounds() {
        return numOfRounds;
    }

    public String getStrategy() {
        return strategy;
    }

    public JRadioButton getR1() {
        return r1;
    }

    public JRadioButton getR2() {
        return r2;
    }

    public String getNameOfPlayer2() {
        return nameOfPlayer2;
    }

    public int getStartingCapital2() {
        return startingCapital2;
    }

    public void printResult(int winnerNumber, String name, int bet, int actualCapital, int rewards) {
        labelPrint.setText("<html>Winner number:  " + winnerNumber + "    name:  " + name + " <br/>" + "bet:    " + bet + " actual capital:     " + actualCapital + "   rewards: " + rewards + "</html>");
    }

    public void printResultforTextarea(int winnerNumber, String name, int bet, int actualCapital, int rewards) {
        textArea.append("Winner number:  " + winnerNumber + "   name:  " + name + "      bet:    " + bet + "     actual capital:     " + actualCapital + "    rewards: " + rewards + "\n");
    }
}
