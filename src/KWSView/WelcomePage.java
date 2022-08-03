package KWSView;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class WelcomePage extends JFrame
{

    Color cyanColor = new Color(173, 238, 226);
    Color aquaColor = new Color(162, 220, 238);
    Color purpleColor = new Color(154, 156, 234);
    Color taroColor = new Color(162, 185, 238);

    private JLabel logoLabel;
    private JLabel welcomeLabel;

    private JButton btnContinue;

    private void createControls()
    {
        logoLabel = new JLabel("<html> <font style = color:#9A9CEA> Khme</font><font style = color:#A2B9EE>r Wo</font><font style = color:#A2DCEE>rd Seg</font><font style = color:#ADEEE2>menter</font><html>", SwingConstants.CENTER);
        logoLabel.setFont(new Font("Trebuchet MS", NORMAL, 60));

        welcomeLabel = new JLabel("<html>Welcome to Khmer Word Segmenter / សូមស្វាគមន៏មកកាន់កម្មវិធី Khmer Word Segmenter​<br/> &#9 &#9 Click 'Continue' to proceed / ចុច 'Continue' ដើម្បីដំណើរការបន្ត<html>", SwingConstants.CENTER);
        welcomeLabel.setForeground(Color.GRAY);


    }

    public WelcomePage()
    {
        createControls();

        ImageIcon logo = new ImageIcon("src/images/logo.png");

        //Set icon to the Window
        setIconImage(logo.getImage());


        JPanel panel1 = new JPanel(new BorderLayout());

        panel1.setBackground(Color.WHITE);

        panel1.add(logoLabel);

        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.add(welcomeLabel, BorderLayout.CENTER);
        panel2.setBackground(Color.WHITE);
        welcomeLabel.setFont(new Font("Khmer OS Metal Chrieng", NORMAL, 20));
        welcomeLabel.setBackground(Color.WHITE);
        welcomeLabel.setBorder(new LineBorder(Color.WHITE));

        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.WHITE);
        panel3.add(btnContinue = new JButton("Continue / បន្ត"));
//        btnContinue.setBackground(purpleColor);
////        btnContinue.setForeground(Color.WHITE);
////        btnContinue.setBorder(new LineBorder(purpleColor));
////        btnContinue.setFont(new Font("Khmer OS Metal Chrieng", NORMAL, 10));
////        btnContinue.setPreferredSize(new Dimension(200, 50));
        btnContinue.setBackground(purpleColor);
        btnContinue.setForeground(Color.WHITE);
        btnContinue.setBorder(new LineBorder(purpleColor));
        btnContinue.setFont(new Font("Khmer OS Metal Chrieng", NORMAL, 20));
        btnContinue.setPreferredSize(new Dimension(225, 50));
        btnContinue.setFocusPainted(false);

        JPanel panel4 = new JPanel(new BorderLayout());
        panel4.add(panel2, BorderLayout.PAGE_START);
        panel4.add(panel3, BorderLayout.CENTER);

        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.add(panel1);
        panel.add(panel4);
        btnContinue.setBackground(purpleColor);
        btnContinue.setForeground(Color.WHITE);
        btnContinue.setFocusPainted(false);


        this.getContentPane().add(panel);
        this.btnContinueListener(new btnListener());
    }
void btnContinueListener(ActionListener listenForBtn)
{
    btnContinue.addActionListener(listenForBtn);
}

class btnListener implements ActionListener
{

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == btnContinue)
        {
            InputPage inputPage = null;
            try {
                inputPage = new InputPage();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

            inputPage.setTitle("Khmer Word Segmenter");
            inputPage.setSize(1280, 720);

            WelcomePage.this.setVisible(false);
            inputPage.setVisible(true);
            inputPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
}
}
