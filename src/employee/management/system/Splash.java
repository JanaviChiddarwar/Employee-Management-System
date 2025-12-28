package employee.management.system; //Package declaration

import java.awt.Image; //For Image class to handle images
import javax.swing.*; //For Swing components like JFrame, JLabel, ImageIcon etc.

public class Splash extends JFrame //Splash screen class extending JFrame
{

    //Constructor
    Splash()
    {
        //Image Loader
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.gif")); //Loading image from resources
        Image i2 = i1.getImage().getScaledInstance(1170, 650, Image.SCALE_DEFAULT); //Scaling the image to fit the splash screen
        ImageIcon i3 = new ImageIcon(i2); //Converting back to ImageIcon
        JLabel image = new JLabel(i3); //Creating a JLabel to hold the image
        image.setBounds(0, 0, 1170, 650); //Setting position and size of the image
        add(image); //Adding image to the JFrame
        
        setSize(1170, 650); //Setting size of splash screen
        setLocation(200, 50); //Setting location of splash screen
        setLayout(null); //No layout manager
        setVisible(true); // To make the splash screen visible

        //Using Thread for time delay
        try
        {
            Thread.sleep(5000);  // 5 seconds
            setVisible(false); // To close the splash screen
            new Login(); //Open Login Page Screen
        }
        catch (Exception e)
        {
            e.printStackTrace(); //Prints the stack trace of the exception for debugging
        }
    }

    public static void main(String[] args)
    {
        new Splash(); //Creating an instance of Splash class to display the splash screen
    }
}