package KWSView;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class AboutUsPage extends JFrame {
    Color cyanColor = new Color(173, 238, 226);
    Color aquaColor = new Color(162, 220, 238);
    Color purpleColor = new Color(154, 156, 234);
    Color taroColor = new Color(162, 185, 238);

    private JLabel logoLabel;
    private JLabel aboutLabel;

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

        aboutLabel = new JLabel("<html>is an application developed in order to segment Khmer texts into definable words and appropriate in respect to its role in the original text.<br/><html>" +
                "<html>This application was developed by a team of us three students during our sophomore year at Royal University of Phnom Penh.<br/><html>" +
                "<html>It was created as a project guided by our teacher, Sokchea KOR. <br/><html>" +
                "<html>ជាកម្មវិធីសម្រាប់បំណែងចែកអត្ថបទឲ្យទៅជាបណ្ដុំនៃពាក្យដែលមានន័យត្រឹមត្រូវ និង សមស្របទៅនឹងអត្ថបទដើម។ វាត្រូវបានបង្កើតឡើង<br/><html>" +
                "<html>ដោយពួកយើង៣នាក់នៅកំឡុងពេលដែលពួកយើងជានិស្សិតឆ្នាំទី២នៃសាកលវិទ្យាល័យភូមិន្ទភ្នំពេញដេប៉ាតេម៉ង់វិស្វកម្មបច្ចេកវិទ្យាព័ត៌មាន។<br/><html>" +
                "<html>កម្មវិធីនេះជាគម្រោងដែលបានដឹកនាំដោយលោកគ្រូ កោរ សុខជា។<br/><html>" +
                "<br/><html>" +
                "<html>The developers' information is as follows:<br/><html>" +
                "<html>ខាងក្រោមនេះជាព័ត៌មានអំពីពួកយើង:<br/><html>" +
                "<br/><html>" +
                "<html>-Ms. Lynith SOKHONN(ក. សុខុន លីនីត)          Email: sokhonnlynit@gmail.com<br/><html>" +
                "<html>-Mr. Manitou PHON(ផុន ម៉ានីទូ)                       <br/><html>" +
                "<html>-Mr. Somnang HENG(ហេង សំណាង)              <br/><html>" +
                "<br/><html>" +
                "<html>Feel free to contact us! ពួកយើងរីករាយនឹងទទួលសារពីអ្នក!<br/><html>");
        aboutLabel.setFont(new Font("Khmer OS Metal Chrieng", NORMAL, 14));


    }

    public AboutUsPage() {
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
        panel3.add(aboutLabel);

        JSplitPane panel = new JSplitPane(SwingConstants.VERTICAL, panel12, panel3);
        panel.setDividerSize(0);


        this.getContentPane().add(panel);

        this.btnHomePageListener(new btnListener());
        this.btnHelpPageListener(new btnListener());
        this.btnFeedBackPageListener(new btnListener());
    }

    void btnHomePageListener(ActionListener listenForBtn) {
        buttons.btnHomePage.addActionListener(listenForBtn);
    }
    void btnHelpPageListener(ActionListener listenForBtn)
    {
        buttons.btnHelpPage.addActionListener(listenForBtn);
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

                AboutUsPage.this.setVisible(false);
                inputPage.setVisible(true);
                inputPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            } else if (source == buttons.btnHelpPage) {

                HelpPage helpPage = new HelpPage();

                helpPage.setTitle("Khmer Word Segmenter");
                helpPage.setSize(1280, 720);

                AboutUsPage.this.setVisible(false);
                helpPage.setVisible(true);
                helpPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
            else if(source == buttons.btnFeedBackPage)
            {
                FeedBackPage feedBackPage = new FeedBackPage();

                feedBackPage.setTitle("Khmer Word Segmenter");
                feedBackPage.setSize(1280, 720);

                AboutUsPage.this.setVisible(false);
                feedBackPage.setVisible(true);
                feedBackPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        }
    }
}

