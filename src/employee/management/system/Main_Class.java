package employee.management.system; //Package declaration

import java.awt.*; //For GUI components like Color, Font etc.
import java.awt.event.ActionEvent; //For ActionEvent handling
import java.awt.event.ActionListener; //For ActionListener interface
import javax.swing.*; //For Swing components like JFrame, JButton, JLabel etc.

public class Main_Class extends JFrame //Main class extending JFrame
{

    //Constructor
    Main_Class()
    {
        //Home Image Loader
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg")); //Loading image from resources
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT); //Scaling the image to fit the main window
        ImageIcon i3 = new ImageIcon(i2); //Converting back to ImageIcon
        JLabel img = new JLabel(i3); //Creating a JLabel to hold the image
        img.setBounds(0, 0, 1120, 630); //Setting position and size of the image
        add(img); //Adding image to the JFrame

        //Heading Label
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM"); //Creating a JLabel for heading
        heading.setBounds(300, 155, 800, 50); //Setting position and size of the heading
        heading.setFont(new Font("Raleway", Font.BOLD, 25)); //Setting font of the heading
        heading.setForeground(Color.BLACK); //Setting text color of the heading
        img.add(heading); //Adding heading to the image JLabel

        //Add Employee Button
        JButton add = new JButton("Add Employee"); //Creating a JButton for continue
        add.setBounds(335, 270, 150, 40); //Setting position and size of the button
        add.setForeground(Color.WHITE); //Setting text color of the button
        add.setBackground(Color.BLACK); //Setting background color of the button
        add.addActionListener(new ActionListener() //Anonymous Inner Class
        {
            @Override //Overriding actionPerformed method
            public void actionPerformed(ActionEvent e) { //Handling Add button click event
                setVisible(false); //Hiding the main window
                new AddEmployee(); //Opening Add Employee window and creating its instance and Login to open Add Window
            }
        });
        img.add(add); //Adding button to the image JLabel

        //View Employees Button
        JButton view = new JButton("View Employees"); //Creating a JButton for continue
        view.setBounds(565, 270, 150, 40); //Setting position and size of the button
        view.setForeground(Color.WHITE); //Setting text color of the button
        view.setBackground(Color.BLACK); //Setting background color of the button
        view.addActionListener(new ActionListener() //Anonymous Inner Class
        {
            @Override //Overriding actionPerformed method
            public void actionPerformed(ActionEvent e) { //Handling View button click event
                setVisible(false); //Hiding the main window
                new View_Employee(); //Opening View Employee window and creating its instance
            }
        });
        img.add(view); //Adding button to the image JLabel

        //Remove Employee Button
        JButton remove = new JButton("Remove Employee"); //Creating a JButton for continue
        remove.setBounds(440, 370, 150, 40); //Setting position and size of the button
        remove.setForeground(Color.WHITE); //Setting text color of the button
        remove.setBackground(Color.BLACK); //Setting background color of the button
        remove.addActionListener(new ActionListener() //Anonymous Inner Class
        {
            @Override //Overriding actionPerformed method
            public void actionPerformed(ActionEvent e) { //Handling Remove button click event
                setVisible(false); //Hiding the main window
                new Remove_Employee(); //Opening Remove Employee window and creating its instance
            }
        });
        img.add(remove); //Adding button to the image JLabel
        
        //JFrame settings for Main_class
        setSize(1120, 630); //Setting size of the main class window
        setLocation(250, 100); //Setting location of the main class window
        setLayout(null); //No layout manager
        setVisible(true); //Making the main class window visible
    }
    public static void main(String[] args)
    {
        new Main_Class(); //Creating an instance of Main_Class to display the main window
    }
}