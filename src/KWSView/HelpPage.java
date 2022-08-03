package KWSView;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class HelpPage extends JFrame {
    Color cyanColor = new Color(173, 238, 226);
    Color aquaColor = new Color(162, 220, 238);
    Color purpleColor = new Color(154, 156, 234);
    Color taroColor = new Color(162, 185, 238);

    private JLabel logoLabel;
    private JLabel helpLabel;

    public class buttons {
        JButton btnHomePage;
        JButton btnHelpPage;
        JButton btnFeedBackPage;
        JButton btnAboutUsPage;
    }

    buttons buttons = new buttons();

    private void createControls() {

        logoLabel = new JLabel("<html> <font style = color:#9A9CEA = >Khme</font><font style = color:#A2B9EE>r Wo</font><font style = color:#A2DCEE>rd Seg</font><font style = color:#ADEEE2>menter</font><html>");
        logoLabel.setFont(new Font("Trebuchet MS", NORMAL, 25));

        helpLabel = new JLabel("<html>Instructions:<br/><html>" +
                "<html>-Type or paste Khmer texts into the column where 'Enter the texts in Khmer. / សូមបញ្ចូលឃ្លាជាភាសាខ្មែរ។' is stated.<br/><html>" +
                "<html>-Click on 'Proceed / បន្ត' to see the results<br/><html>" +
                "<html>-Click on 'Reset / បញ្ចូលសារជាថ្មី' to reset the input and the result.<br/><html>" +
                "<html>Others:<br/><html>" +
                "<html>-Choose 'Home' to revisit the home page.<br/><html>" +
                "<html>-Choose 'Feedback' to proceed reporting issues or mistakes or giving comments.<br/><html>" +
                "<html>-Choose 'About us' to see information about the applications and developers.<br/><html>" +
                "<html>វិធីប្រើប្រាស់:<br/><html>" +
                "<html>-បញ្ចូលអត្ថបទជាភាសាខ្មែរនៅក្នុងប្រអប់ដែលដាក់ថា 'Enter the texts in Khmer. / សូមបញ្ចូលឃ្លាជាភាសាខ្មែរ។' ។<br/><html>" +
                "<html>-ចុចលើ 'Proceed / បន្ត' ដើម្បីមើលលទ្ធផល។<br/><html>" +
                "<html>-ចុចលើ 'Reset / បញ្ចូលសារជាថ្មី' ដើម្បីលុបលទ្ធផលចាស់ហើយបញ្ចូលនូវប្រយោគថ្មី។<br/><html>" +
                "<html>ផ្សេងៗ:<br/><html>" +
                "<html>-ជ្រើសរើស 'Back to Homepage' ដើម្បីត្រឡប់ទៅកាន់ទំព័រដើមវិញ។<br/><html>" +
                "<html>-ជ្រើសរើស 'Feedback' ដើម្បីធ្វើការឲ្យដំណឹងសម្រាប់នូវរាល់បញ្ហា ឬ កំហុស ដែលបានរកឃើញ ឬ ដើម្បីផ្តល់ជាមតិយោបល់។<br/><html>" +
                "<html>-ជ្រើសរើស 'About us' ដើម្បីអានអំពីព័ត៌មាននៃកម្មវិធី និង អ្នកបង្កើតវា។<br/><html>");
        helpLabel.setFont(new Font("Khmer OS Metal Chrieng", NORMAL, 16));


    }

    public HelpPage() {
        createControls();

        ImageIcon logo = new ImageIcon("src/images/logo.png");

        setIconImage(logo.getImage());

        buttons.btnHomePage = new JButton("<html>Home <br/> ទំព័រដើម<html>");
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
        panel3.setBackground(Color.WHITE);
        panel3.add(helpLabel);

        JSplitPane panel = new JSplitPane(SwingConstants.VERTICAL, panel12, panel3);
        panel.setDividerSize(0);


        this.getContentPane().add(panel);

        this.btnHomePageListener(new btnListener());
        this.btnAboutUsPageListener(new btnListener());
        this.btnFeedBackPageListener(new btnListener());
    }

    void btnHomePageListener(ActionListener listenForBtn) {
        buttons.btnHomePage.addActionListener(listenForBtn);
    }
    void btnAboutUsPageListener(ActionListener listenForBtn)
    {
        buttons.btnAboutUsPage.addActionListener(listenForBtn);
    }
    void btnFeedBackPageListener(ActionListener listenForBtn)
    {
        buttons.btnFeedBackPage.addActionListener(listenForBtn);
    }


    public class btnListener implements ActionListener {



        @Override
        public void actionPerformed(ActionEvent e) {

                Object source = e.getSource();
                if (source == buttons.btnHomePage) {
                    InputPage inputPage = null;
                    try {
                        inputPage = new InputPage();
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }

                    inputPage.setTitle("Khmer Word Segmenter");
                    inputPage.setSize(1280, 720);

                    HelpPage.this.setVisible(false);
                    inputPage.setVisible(true);
                    inputPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } else if (source == buttons.btnAboutUsPage) {
                    AboutUsPage aboutUsPage = new AboutUsPage();

                    aboutUsPage.setTitle("Khmer Word Segmenter");
                    aboutUsPage.setSize(1280, 720);

                    HelpPage.this.setVisible(false);
                    aboutUsPage.setVisible(true);
                    aboutUsPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
                else if(source == buttons.btnFeedBackPage)
                {
                    FeedBackPage feedBackPage = new FeedBackPage();

                    feedBackPage.setTitle("Khmer Word Segmenter");
                    feedBackPage.setSize(1280, 720);

                    HelpPage.this.setVisible(false);
                    feedBackPage.setVisible(true);
                    feedBackPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
            }
        }
    }


