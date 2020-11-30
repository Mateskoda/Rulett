package WorkingArea;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface extends JFrame implements ActionListener {
    JRadioButton r1;
    JRadioButton r2;
    JFrame f;
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

    JComboBox comboOfBets;
    JComboBox comboNumsOnWheel;
    static String nameOfPlayer = "";
    String rangedBet;
    Integer numBet;
    static int startingCapital;


    public UserInterface() {
        f = new JFrame();
        f.getContentPane().setBackground(Color.GRAY);

        myGamePanel1 = myGame1();
        myGamePanel2 = myGame2();
        myGamePanel1.setSize(800, 600);

        radioButtons = new JPanel();
        r1 = new JRadioButton("szimulaciót szeretnék futtatni");
        r2 = new JRadioButton("játszani szeretnék egyet!");
        radioButtons.add(r1);
        radioButtons.add(r2);
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);                      //azert kell ButtonGroup ba tenni oket, hogy egyszerre csak egy lehessen kivalasztva!!!
        r1.addActionListener(this);
        r1.addActionListener(this);

        JLabel lab1 = new JLabel("Üvözölük a rulett játékban!");

       panel=new JPanel();
        panel.add(radioButtons);

        f.add(panel);
        f.setSize(800, 600);
        f.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (r1.isSelected()) {
            f.remove(panel);
            f.add(myGamePanel1);
            //f.pack();
            f.setVisible(true);
            submit1.addActionListener(this);

        }
        if (r2.isSelected()) {

        }

        if (e.getSource() == submit1) {
            //System.out.println("hello");
            System.out.println(tfname.getText());
            nameOfPlayer = tfname.getText() + "";
            System.out.println(tfstartingCapital.getText());
            startingCapital = Integer.parseInt(tfstartingCapital.getText());

            f.remove(myGamePanel1);
            f.add(myGamePanel2);
            //f.pack();
            f.setVisible(true);
            submit2.addActionListener(this);


        }
        if (e.getSource() == submit2) {
            //System.out.println("hello");
            rangedBet = (String) comboOfBets.getSelectedItem();

            System.out.println(rangedBet);

            numBet = (Integer) comboNumsOnWheel.getSelectedItem();

            System.out.println(numBet); //f.remove(myGamePanel1);
            // f.add(myGamePanel2);
            //f.pack();
            f.setVisible(true);
            submit2.addActionListener(this);

        }
    if(e.getSource()==btReturn2 || e.getSource()==btReturn2 ){

    }


    }

    public JPanel myGame1() {
        tfname = new JTextField("adja meg a nevet!", 20);
        tfstartingCapital = new JTextField("adja meg a játékra szánt pénzét!", 10);
        submit1 = new JButton("elküldés");
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
        myGamePanel2 = new JPanel();

        String[] bets = {"odds", "evens", "highs", "lows", "red", "black"};
        comboOfBets = new JComboBox<String>(bets);
        Integer[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36};
        comboNumsOnWheel = new JComboBox<>(nums);
        JPanel gamePan = new JPanel();
        submit2 = new JButton("mehet a pörgettés!");
        btReturn3 = new JButton("vissza");
        tfBetAmount = new JTextField("mekkora a tét?");

        gamePan.setPreferredSize(new Dimension(600, 500));


        //gamePan.setLayout(new BoxLayout(gamePan,BoxLayout.Y_AXIS));
        nameLabel.setText("Hello kedves " + nameOfPlayer + " kerem tedd meg a tétedet és a fogadásodat!");

        gamePan.add(nameLabel);
        gamePan.add(new JLabel("válassz a mezők közül, vagy adj meg egy számot"));
        gamePan.add(comboOfBets);
        gamePan.add(comboNumsOnWheel);
        gamePan.add(new JLabel("mennyi pézben fogadsz?"));
        gamePan.add(tfBetAmount);

        myGamePanel2.add(gamePan);
        myGamePanel2.add(submit2);
        myGamePanel2.add(btReturn3);

        return myGamePanel2;
    }


}


