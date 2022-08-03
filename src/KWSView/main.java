package KWSView;
import javax.swing.*;
import java.io.FileNotFoundException;

public class KWS {
public static void main(String[] args)throws FileNotFoundException
{
    //Instantiate WelcomePage as the first window to appear
    WelcomePage home = new WelcomePage();
    home.setTitle("Khmer Word Segmenter");
    home.setSize(1280,720);
    home.setLocation(0, 0);
    home.setVisible(true);
    home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
