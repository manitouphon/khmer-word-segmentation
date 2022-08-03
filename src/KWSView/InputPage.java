package KWSView;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.plaf.basic.BasicScrollBarUI;

import KWSModel.Segment;

public class InputPage extends JFrame {



    Segment segment = new Segment();
    ArrayList<String> result = new ArrayList<String>();


    Color cyanColor = new Color(173, 238, 226);
    Color aquaColor = new Color(162, 220, 238);
    Color purpleColor = new Color(154, 156, 234);
    Color taroColor = new Color(162, 185, 238);

    private JLabel logoLabel;

    private JTextArea resultArea;
    private JTextArea inputArea;

    private JScrollPane inputScroll;
    private JScrollPane resultScroll;

    private String inputString;

    public class buttons
    {
        JButton btnProceed;
        JButton btnReset;
        JButton btnHomePage;
        JButton btnHelpPage;
        JButton btnFeedBackPage;
        JButton btnAboutUsPage;
    }
    buttons buttons = new buttons();

    private void createControls()
    {
        logoLabel = new JLabel("<html> <font style = color:#9A9CEA = > &#32; Khme</font><font style = color:#A2B9EE>r Wo</font><font style = color:#A2DCEE>rd Seg</font><font style = color:#ADEEE2>menter</font><html> " );
        logoLabel.setFont(new Font("Trebuchet MS", NORMAL, 25));


        inputArea = new JTextArea();
        inputArea.setFont(new Font("Khmer OS Metal Chrieng", NORMAL, 16));
        inputArea.setLineWrap(true);
        inputArea.setVisible(true);
        inputScroll = new JScrollPane(inputArea);


        resultArea = new JTextArea("Please enter the text first... / សូមវាយបញ្ចូលប្រយោគជាមុនសិន...");
        resultArea.setFont(new Font("Khmer OS", NORMAL, 16));
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setVisible(true);
        resultScroll = new JScrollPane(resultArea);


    }

    public InputPage() throws FileNotFoundException {
        createControls();

        ImageIcon logo = new ImageIcon("src/images/logo.png");

        //Set icon to the Window
        setIconImage(logo.getImage());

        inputString = inputArea.getText();

        buttons.btnHomePage = new JButton("<html>&#32;Home <br/> ទំព័រដើម<html>");
        buttons.btnHomePage.setFont(new Font("Khmer OS Metal Chrieng", NORMAL, 20));
        buttons.btnHomePage.setPreferredSize(new Dimension(250, 80));
        buttons.btnHomePage.setBackground(purpleColor);
        buttons.btnHomePage.setBorder(new LineBorder(purpleColor));
        buttons.btnHomePage.setForeground(Color.WHITE);
        buttons.btnHomePage.setFocusPainted(false);
        buttons.btnHelpPage = new JButton("<html>Help <br/> ជំនួយ<html>");
        buttons.btnHelpPage.setFont(new Font("Khmer OS Metal Chrieng", NORMAL, 20));
        buttons.btnHelpPage.setPreferredSize(new Dimension(250, 80));
        buttons.btnHelpPage.setBackground(taroColor);
        buttons.btnHelpPage.setBorder(new LineBorder(taroColor));
        buttons.btnHelpPage.setForeground(Color.WHITE);
        buttons.btnHelpPage.setFocusPainted(false);
        buttons.btnFeedBackPage = new JButton("<html>FeedBack <br/> ឲ្យយោបល់<html>");
        buttons.btnFeedBackPage.setFont(new Font("Khmer OS Metal Chrieng", NORMAL, 20));
        buttons.btnFeedBackPage.setPreferredSize(new Dimension(250, 80));
        buttons.btnFeedBackPage.setBackground(aquaColor);
        buttons.btnFeedBackPage.setBorder(new LineBorder(aquaColor));
        buttons.btnFeedBackPage.setForeground(Color.WHITE);
        buttons.btnFeedBackPage.setFocusPainted(false);
        buttons.btnAboutUsPage = new JButton("<html>About Us <br/> អំពីពួកយើង<html>");
        buttons.btnAboutUsPage.setFont(new Font("Khmer OS Metal Chrieng", NORMAL, 20));
        buttons.btnAboutUsPage.setPreferredSize(new Dimension(250, 80));
        buttons.btnAboutUsPage.setBackground(cyanColor);
        buttons.btnAboutUsPage.setBorder(new LineBorder(cyanColor));
        buttons.btnAboutUsPage.setForeground(Color.WHITE);
        buttons.btnAboutUsPage.setFocusPainted(false);

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.WHITE);
        panel1.add(logoLabel);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.WHITE);
        GridBagLayout layout = new GridBagLayout();
        panel2.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.VERTICAL;

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel2.add(buttons.btnHomePage, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel2.add(buttons.btnHelpPage, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel2.add(buttons.btnFeedBackPage, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel2.add(buttons.btnAboutUsPage, gbc);


        JPanel panel12 = new JPanel(new BorderLayout());
        panel12.add(panel1, BorderLayout.NORTH);
        panel12.add(panel2);

        JPanel panel3 = new JPanel();
//        JScrollPane scrollInput = new JScrollPane(inputArea);
        panel3.setBackground(Color.WHITE);
        panel3.add(inputScroll);
//        JPanel panel3 = new JPanel();
//        JScrollPane scrollInput = new JScrollPane(inputArea);
//        panel3.setBackground(Color.WHITE);
//        panel3.add(scrollInput);

        JPanel panel4 = new JPanel();
        panel4.setBackground(Color.WHITE);
        panel4.add(buttons.btnProceed = new JButton("Proceed / បន្ត"));

        JPanel panel34 = new JPanel(new BorderLayout());
        panel34.add(panel4, BorderLayout.NORTH);
        panel34.add(panel3);

        JPanel panel5 = new JPanel();
        panel5.setBackground(Color.WHITE);
        panel5.add(buttons.btnReset = new JButton("Reset / បញ្ចូលសារជាថ្មី"));

//        JPanel panel6 = new JPanel();
//        JScrollPane scrollResult = new JScrollPane(resultArea);
//        panel6.add(scrollResult);
//        panel6.setBackground(Color.WHITE);
        JPanel panel6 = new JPanel();
//        JScrollPane scrollResult = new JScrollPane(resultArea);
        panel6.add(resultScroll);
        resultScroll.getVerticalScrollBar().setBackground(cyanColor);
        resultScroll.setFocusable(false);
        panel6.setBackground(Color.WHITE);

        JPanel panel56 = new JPanel(new BorderLayout());
        panel56.add(panel5, BorderLayout.NORTH);
        panel56.add(panel6);

        JPanel mainPanel = new JPanel(new GridLayout(2,1));
        mainPanel.add(panel34);
        mainPanel.add(panel56);

        JSplitPane panel = new JSplitPane(SwingConstants.VERTICAL, panel12 , mainPanel);
        panel.setDividerSize(0);


//        inputArea.setPreferredSize(new Dimension(950, 250));
//        inputArea.setBorder(new LineBorder(Color.GRAY));
        inputScroll.setPreferredSize(new Dimension(950, 250));
        inputScroll.setBorder(new LineBorder(Color.GRAY));
        inputScroll.getVerticalScrollBar().setBackground(aquaColor);
        inputScroll.setFocusable(false);
        inputScroll.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = taroColor;
            }
        });


//        resultArea.setPreferredSize(new Dimension(950, 250));
//        resultArea.setBackground(Color.WHITE);
//        resultArea.setBorder(new LineBorder(Color.GRAY));
        resultScroll.setPreferredSize(new Dimension(950, 250));
        resultScroll.setBackground(Color.WHITE);
        resultScroll.setBorder(new LineBorder(Color.GRAY));
        resultScroll.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = taroColor;
            }
        });

        buttons.btnReset.setBackground(purpleColor);
        buttons.btnReset.setForeground(Color.WHITE);
        buttons.btnReset.setBorder(new LineBorder(purpleColor));
        buttons.btnReset.setFont(new Font("Khmer OS Metal Chrieng", NORMAL, 20));
        buttons.btnReset.setPreferredSize(new Dimension(225, 50));
        buttons.btnReset.setFocusPainted(false);
        buttons.btnProceed.setBackground(purpleColor);
        buttons.btnProceed.setForeground(Color.WHITE);
        buttons.btnProceed.setBorder(new LineBorder(purpleColor));
        buttons.btnProceed.setFont(new Font("Khmer OS Metal Chrieng", NORMAL, 20));
        buttons.btnProceed.setPreferredSize(new Dimension(225, 50));
        buttons.btnProceed.setFocusPainted(false);


        this.getContentPane().add(panel);

        this.btnProceedListener(new btnListener());
        this.btnResetListener(new btnListener());
        this.btnHelpPageListener(new btnListener());
        this.btnAboutUsPageListener(new btnListener());
        this.btnFeedBackPageListener(new btnListener());

        this.addWindowListener(new WindowAdapter()
        {
            public void windowOpened(WindowEvent e)
            {
                inputArea.requestFocus();
            }
        });


    }


    void btnResetListener(ActionListener listenForBtn)
    {
        buttons.btnReset.addActionListener(listenForBtn);
    }
    void btnProceedListener(ActionListener listenForBtn)
    {
        buttons.btnProceed.addActionListener(listenForBtn);
    }
    void btnHelpPageListener(ActionListener listenForBtn)
    {
        buttons.btnHelpPage.addActionListener(listenForBtn);
    }
    void btnFeedBackPageListener(ActionListener listenForBtn)
    {
        buttons.btnFeedBackPage.addActionListener(listenForBtn);
    }
    void btnAboutUsPageListener(ActionListener listenForBtn)
    {
        buttons.btnAboutUsPage.addActionListener(listenForBtn);
    }

    public class btnListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();

            if(source == buttons.btnProceed)
            {
                try {
                    result.removeAll(result);
                    try {
                        segment = new Segment();
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    inputString = inputArea.getText();
                    result = segment.doSegmentation(inputString);

                    resultArea.setText(String.valueOf(result));
                    resultArea.setLineWrap(true);
                }catch (IndexOutOfBoundsException i)
                {
                    inputArea.setText("");
                    inputArea.requestFocus();
                    resultArea.setText("Invalid language input! Please enter only in Khmer language. / សូមវាយបញ្ចូលជាភាសាខ្មែរ។");
                }

            }

            else if(source == buttons.btnReset)
            {

                    result.clear();
                inputArea.setText("");
                resultArea.setText("Please enter the text first... / សូមវាយបញ្ចូលប្រយោគជាមុនសិន...");
                inputArea.requestFocus();


            }
            else if(source == buttons.btnHelpPage)
            {
                HelpPage helpPage = new HelpPage();

                helpPage.setTitle("Khmer Word Segmenter");
                helpPage.setSize(1280, 720);

                InputPage.this.setVisible(false);
                helpPage.setVisible(true);
                helpPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
            else if(source == buttons.btnAboutUsPage)
            {
                AboutUsPage aboutUsPage = new AboutUsPage();

                aboutUsPage.setTitle("Khmer Word Segmenter");
                aboutUsPage.setSize(1280, 720);

                InputPage.this.setVisible(false);
                aboutUsPage.setVisible(true);
                aboutUsPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
            else if(source == buttons.btnFeedBackPage)
            {
                FeedBackPage feedBackPage = new FeedBackPage();

                feedBackPage.setTitle("Khmer Word Segmenter");
                feedBackPage.setSize(1280, 720);

                InputPage.this.setVisible(false);
                feedBackPage.setVisible(true);
                feedBackPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }

        }

    }


}
