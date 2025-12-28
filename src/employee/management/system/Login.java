package employee.management.system; //Package declaration

import java.awt.*; //For GUI components like Color, Font etc.
import java.awt.event.ActionEvent; //For ActionEvent handling
import java.awt.event.ActionListener; //For ActionListener interface
import java.sql.ResultSet; //For handling SQL query results
import javax.swing.*; //For Swing components like JFrame, JButton, JLabel, JTextField etc.

public class Login extends JFrame implements ActionListener //Login class extending JFrame and implementing ActionListener
{
    //Global Variable declaration for text fields and is overridden in ActionPerformed
    JTextField tusername; //TextField for username
    JPasswordField tpassword; //PasswordField for password

    //Global Variable declaration for buttons
    JButton login; //Buttons for login
    JButton back; //Buttons for cancel

    //Constructor
    Login()
    {

        //Username Label
        JLabel username = new JLabel("Username:"); //Creating a JLabel for username
        username.setBounds(40, 20, 100, 30); //Setting position and size of the label
        add(username); //Adding label to the JFrame

        //Username TextField
        tusername = new JTextField(); //Creating a TextField for username input
        tusername.setBounds(150, 20, 150, 30); //Setting position and size of the TextField
        add(tusername); //Adding TextField to the JFrame

        //Password Label
        JLabel password = new JLabel("Password:"); //Creating a JLabel for password
        password.setBounds(40, 70, 100, 30); //Setting position and size of the label
        add(password); //Adding label to the JFrame

        //Password TextField
        tpassword = new JPasswordField(); //Creating a PasswordField for password input
        tpassword.setBounds(150, 70, 150, 30); //Setting position and size of the PasswordField
        add(tpassword); //Adding PasswordField to the JFrame

        //Login Button
        login = new JButton("LOGIN"); //Creating a JButton for login
        login.setBounds(150, 140, 150, 30); //Setting position and size of the button
        login.setBackground(Color.BLACK); //Setting background color of the button
        login.setForeground(Color.WHITE); //Setting text color of the button
        login.addActionListener(this);
        add(login); //Adding button to the JFrame

        //Back Button
        back = new JButton("BACK"); //Creating a JButton for cancel
        back.setBounds(150, 180, 150, 30); //Setting position and size of the button
        back.setBackground(Color.BLACK); //Setting background color of the button
        back.setForeground(Color.WHITE); //Setting text color of the button
        back.addActionListener(this);
        add(back); //Adding button to the JFrame

        //Second Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg")); //Loading image from resources
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT); //Scaling the image to fit the login screen
        ImageIcon i3 = new ImageIcon(i2); //Converting back to ImageIcon
        JLabel img = new JLabel(i3); //Creating a JLabel to hold the image
        img.setBounds(350, 10, 600, 400); //Setting position and size of the image
        add(img); //Adding image to the JFrame

        //Background Image
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg")); //Loading image from resources
        Image i22 = i11.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT); //Scaling the image to fit the login screen
        ImageIcon i33 = new ImageIcon(i22); //Converting back to ImageIcon
        JLabel imgg = new JLabel(i33); //Creating a JLabel to hold the image
        imgg.setBounds(0, 0, 600, 300); //Setting position and size of the image
        add(imgg); //Adding image to the JFrame

        setSize(600, 300); //Setting size of login screen
        setLocation(450, 200); //Setting location of login screen
        setLayout(null); //No layout manager
        setVisible(true); // To make the login screen visible
    }

    //For handling button click events and overriding actionPerformed method from globally declared variables
    @Override
    public void actionPerformed(ActionEvent e) //Overriding actionPerformed method
    {
        if(e.getSource() == login) //If the login button is clicked
        {
            try //Try-Catch block for exception handling
            {
                String username = tusername.getText(); //Getting username from TextField
                String password = tpassword.getText(); //Getting password from PasswordField

                conn c = new conn(); //Creating an instance of the conn class to connect to the database
                
                String query = "select * from login where username = '"+ username +"' and password = '"+ password +"'"; //SQL query to check username and password
                ResultSet resultSet = c.statement.executeQuery(query); //Executing the query and getting the result set

                if(resultSet.next()) //If a matching record is found
                {
                    setVisible(false); //Hiding the login screen
                    new Main_Class(); //Opening the main class window
                }
                else //If no matching record is found
                {
                    JOptionPane.showMessageDialog(null, "Invalid username or password"); //Showing error message for invalid credentials
                    setVisible(false); //Hiding the login screen
                }

            }
            catch (Exception E) //Catch block to handle exceptions
            {
                E.printStackTrace(); //Prints the stack trace of the exception for debugging
            }
        }
        else if(e.getSource() == back) //If the back button is clicked
        {
            System.exit(90);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}