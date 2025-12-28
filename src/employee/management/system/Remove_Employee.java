package employee.management.system; //Remove_Employee class for removing an employee record

import java.awt.*; //For Swing components like JFrame, JButton, JLabel etc.
import java.awt.event.ActionEvent;  //For GUI components like Color, Font etc.
import java.awt.event.ActionListener; //For ActionEvent handling
import java.awt.event.ItemEvent; //For ActionListener interface
import java.awt.event.ItemListener; //For ItemEvent handling
import java.sql.ResultSet; //For ItemListener interface
import javax.swing.*; //For ResultSet class to hold data retrieved from the database

public class Remove_Employee extends JFrame implements ActionListener //Remove_Employee class extending JFrame and implementing ActionListener
{

    //Choice dropdown for employee ids
    Choice choiceEMPID; //Dropdown for employee ids

    //Buttons for Delete and Back actions
    JButton delete, back; //JButton components for Delete and Back actions

    // Constructor
    Remove_Employee()
    {

        //Setting up the JFrame properties and components and Heading of Employee ID
        JLabel label = new JLabel("Employee ID"); //Creating a JLabel for Employee ID
        label.setBounds(50,50,100,30); //Setting position and size of the label
        label.setFont(new Font("Tahoma", Font.BOLD,15)); //Setting font of the label
        add(label); //Adding label to the JFrame

        //Choice component for Employee IDs dropdown
        choiceEMPID = new Choice(); //Creating a Choice component for employee IDs dropdown
        choiceEMPID.setBounds(200,50,150,30); //Setting position and size of the Choice component
        add(choiceEMPID);   //Adding Choice component to the JFrame

        //Populate choiceEMPID with employee IDs from the database
        try //Try-Catch block for exception handling
        {
            conn c = new conn(); //Creating an instance of conn class to establish database connection
            ResultSet resultSet = c.statement.executeQuery("select * from employee"); //Executing SQL query to retrieve all employee records
            while (resultSet.next()) //Iterating through the result set
            {
                choiceEMPID.add(resultSet.getString("empId")); //Adding employee ID to the Choice component
            }
        }
        catch (Exception e) //Catch block to handle exceptions
        {
            e.printStackTrace(); //Prints the stack trace of the exception for debugging
        }

        //Labels and fields for displaying employee details
        JLabel labelName = new JLabel("Name"); //Creating a JLabel for Name
        labelName.setBounds(50,100,100,30); //Setting position and size of the label
        labelName.setFont(new Font("Tahoma", Font.BOLD,15)); //Setting font of the label
        add(labelName); //Adding label to the JFrame

        //Text label to show Name
        JLabel textName = new JLabel(); //Creating a JLabel to display the employee name
        textName.setBounds(200,100,100,30); //Setting position and size of the text label
        add(textName); //Adding text label to the JFrame

        //Phone label
        JLabel labelPhone = new JLabel("Phone"); //Creating a JLabel for Phone
        labelPhone.setBounds(50,150,100,30); //Setting position and size of the label
        labelPhone.setFont(new Font("Tahoma", Font.BOLD,15)); //Setting font of the label
        add(labelPhone); //Adding label to the JFrame

        //Text label to show Phone
        JLabel textPhone = new JLabel(); //Creating a JLabel to display the employee phone number
        textPhone.setBounds(200,150,100,30); //Setting position and size of the text label
        add(textPhone); //Adding text label to the JFrame

        //Email label
        JLabel labelemail = new JLabel("Email"); //Creating a JLabel for Email
        labelemail.setBounds(50,200,100,30); //Setting position and size of the label
        labelemail.setFont(new Font("Tahoma", Font.BOLD,15)); //Setting font of the label
        add(labelemail); //Adding label to the JFrame

        //Text label to show Email
        JLabel textEmail = new JLabel(); //Creating a JLabel to display the employee email
        textEmail.setBounds(200,200,100,30); //Setting position and size of the text label
        add(textEmail); //Adding text label to the JFrame

        //Fetch and display details of the initially selected employee ID
        try //Try-Catch block for exception handling
        {
            conn c = new conn(); //Creating an instance of conn class to establish database connection
            ResultSet resultSet = c.statement.executeQuery("select * from employee where empId = '"+choiceEMPID.getSelectedItem()+"'"); //Executing SQL query to retrieve details of the selected employee ID
            while (resultSet.next()) //Iterating through the result set
            {
                textName.setText(resultSet.getString("name")); //Setting name in the Name TextField
                textPhone.setText(resultSet.getString("phone")); //Setting phone in the Phone TextField
                textEmail.setText(resultSet.getString("email")); //Setting email in the Email TextField
            }
        }
        catch (Exception e) //Catch block to handle exceptions
        {
            e.printStackTrace(); //Prints the stack trace of the exception for debugging
        }

        //Add ItemListener to choiceEMPID to update details when a different employee ID is selected
        choiceEMPID.addItemListener(new ItemListener() //Anonymous Inner Class for ItemListener
        {
            //Overriding itemStateChanged method
            @Override
            public void itemStateChanged(ItemEvent e)  //Method to handle item selection changes in the Choice component and update employee details accordingly
            {
                try //Try-Catch block for exception handling
                {
                    conn c = new conn(); //Creating an instance of conn class to establish database connection
                    ResultSet resultSet = c.statement.executeQuery("select * from employee where empId = '"+choiceEMPID.getSelectedItem()+"'"); //Executing SQL query to retrieve details of the selected employee ID
                    while (resultSet.next()) //Iterating through the result set
                    {
                        textName.setText(resultSet.getString("name")); //Setting name in the Name TextField
                        textPhone.setText(resultSet.getString("phone")); //Setting phone in the Phone TextField
                        textEmail.setText(resultSet.getString("email")); //Setting email in the Email TextField
                    }
                }
                catch (Exception E) //Catch block to handle exceptions
                {
                    E.printStackTrace(); //Catch block to handle exceptions
                }
            }
        });

        //Button for Delete
        delete = new JButton("Delete"); // Converting JButton for Delete action.
        delete.setBounds(80,300,100,30); // Setting position and size of the delete button.
        delete.setBackground(Color.black); // Setting background color of the delete button to black.
        delete.setForeground(Color.WHITE); // Setting text color of the delete button to white.
        delete.addActionListener(this); // Adding action listener to the delete button.
        add(delete); // Adding delete button to the JFrame.

        //Button for Back
        back = new JButton("Back"); // Converting JButton for back action.
        back.setBounds(220,300,100,30); // Setting position and size of the back button.
        back.setBackground(Color.black); // Setting background color of the back button to black.
        back.setForeground(Color.WHITE); // Setting text color of the back button to white.
        back.addActionListener(this); // Adding action on listener to the back button.
        add(back); // Adding back button to the JFrame.

        //Image Loader
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png")); // Loading image for resources.
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT); // Scaling the image to fit the Screen.
        ImageIcon i3 = new ImageIcon(i2); // Converting back to image icon.
        JLabel img = new JLabel(i3); // Creating JLabel to hold the image.
        img.setBounds(700,80,200,200); // Setting position and size of the image.
        add(img); // Adding image to the JFrame.

        //Image Loader
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/rback.png")); // Loading image for resources.
        Image i22 = i11.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT); // Scaling the image to fit the Screen.
        ImageIcon i33 = new ImageIcon(i22); // Converting back to image icon.
        JLabel image = new JLabel(i33); // Creating JLabel to hold the image.
        image.setBounds(0,0,1120,630); // Setting position and size of the image.
        add(image); // Adding image to the JFrame.

        //JFrame setting
        setSize(1000,400); // Setting size of the JFrame.
        setLocation(300,150); // Setting location of the JFrame.
        setLayout(null); // No layout manager.
        setVisible(true); // Making the JFrame visible.

    }

    // ActionListener method to handle button clicks and overrides actionPerformed method
    @Override
    public void actionPerformed(ActionEvent e) { // Method to handle button click events by the user by implementing ActionListener or overriding actionPerformed method
        if (e.getSource()==delete) // If delete button is clicked.
        {
            try //Try-Catch block for exception handling
            {
                conn c = new conn(); // Creating an instance of an conn class to establish database connection.
                String query = "delete from employee where empId = '"+choiceEMPID.getSelectedItem()+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee Deleted Sucessfully"); // Showing message. 
                setVisible(false); // Hiding the current window.
                new Main_Class(); // Opening main class window and creating its instance.

            }
            catch (Exception E) //Catch block to handle exceptions
            {
                E.printStackTrace();//Prints the stack trace of the exception for debugging
            }
        }
        else
        {
            setVisible(false);
        }
    }
    
    public static void main(String[] args)
    {
        new Remove_Employee(); //Creating an instance of Remove_Employee to display the window
    }
}