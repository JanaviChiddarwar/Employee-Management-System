package employee.management.system; //Package declaration

import java.awt.*; //For GUI components like Color, Font etc.
import java.awt.event.ActionEvent; //For ActionEvent handling
import java.awt.event.ActionListener; //For ActionListener interface
import java.sql.ResultSet; //For ResultSet class to handle results from SQL queries
import javax.swing.*; //For Swing components like JFrame, JButton, JLabel, JTextField etc.

public class Update_Employee extends JFrame implements ActionListener //Update Employee class extending JFrame and implementing ActionListener
{

    //Globally declare components
    JTextField teducation, tsurname, taddress,tphone, taadhar, temail, tsalary,tdesignation; //TextFields for employee details

    //Labels for displaying non-editable employee details
    JLabel tempid; //Label for Employee ID

    // Buttons for actions
    JButton add, back; //JButton components for Add and Back actions

    // Variable to hold employee number and identify which employee to update
    String number; // Employee number

    // Constructor
    Update_Employee(String number)
    {
        // Initialize employee number
        this.number = number; //Assigning the passed employee number to the class variable
        getContentPane().setBackground(new Color(163,255,188)); //Setting background color of the JFrame

        // Add Employee Detail Heading Label
        JLabel heading = new JLabel("Add Employee Detail"); //Creating a JLabel for heading
        heading.setBounds(320,30,500,50); //Setting position and size of the heading label
        heading.setFont(new Font("serif", Font.BOLD,25)); //Setting font of the heading label
        add(heading); // Adding heading label to the JFrame

        // Labels Employee Details as Name
        JLabel name = new JLabel("Name"); //Creating a JLabel for Name
        name.setBounds(50,150,150,30); //Setting position and size of the Name label
        name.setFont(new Font("SAN_SERIF", Font.BOLD,20)); //Setting font of the Name label
        add(name);  //Adding Name label to the JFrame

        //TextField to display employee name
        JLabel tname = new JLabel(); //Creating a TextField to display employee name
        tname.setBounds(200,150,150,30); //Setting position and size of the Name display label
        tname.setBackground(new Color(177,252,197)); //Setting background color of the Name display label
        add(tname); //Adding Name display label to the JFrame

        // Labels Employee Details as Father's Name
        JLabel surname = new JLabel("Surname"); //Creating a JLabel for Father's Name
        surname.setBounds(400,150,150,30); //Setting position and size of the Father's Name label
        surname.setFont(new Font("SAN_SERIF", Font.BOLD,20)); //Setting font of the Father's Name label
        add(surname); //Adding Father's Name label to the JFrame

        //TextField to input father's name
        tsurname = new JTextField(); //Creating a TextField to input father's name
        tsurname.setBounds(600,150,150,30); //Setting position and size of the Father's Name TextField
        tsurname.setBackground(new Color(177,252,197)); // Setting background color of the Father's Name TextField
        add(tsurname); //Adding Father's Name TextField to the JFrame

        // Labels Employee Details as Date Of Birth
        JLabel dob = new JLabel("Date Of Birth"); //Creating a JLabel for Date of Birth
        dob.setBounds(50,200,150,30); //Setting position and size of the Date of Birth label
        dob.setFont(new Font("SAN_SERIF", Font.BOLD,20)); //Setting font of the Date of Birth label
        add(dob); //Adding Date of Birth label to the JFrame

        //TextField to display date of birth
        JLabel tdob = new JLabel(); //Creating a TextField to display date of birth
        tdob.setBounds(200,200,150,30); //Setting position and size of the Date of Birth display label
        tdob.setFont(new Font("Tahoma", Font.BOLD, 20)); //Setting font of the Date of Birth display label
        tdob.setBackground(new Color(177,252,197)); //Setting background color of
        add(tdob); //Adding Date of Birth display label to the JFrame

        // Labels Employee Details as Salary
        JLabel salary = new JLabel("Salary"); //Creating a JLabel for Salary
        salary.setBounds(400,200,150,30); //Setting position and size of the Salary label
        salary.setFont(new Font("SAN_SERIF", Font.BOLD,20)); //Setting font of the Salary label
        add(salary); //Adding Salary label to the JFrame

        //TextField to input salary
        tsalary = new JTextField(); //Creating a TextField to input salary
        tsalary.setBounds(600,200,150,30); //Setting position and size of the Salary TextField
        tsalary.setBackground(new Color(177,252,197)); //Setting background color of the Salary TextField
        add(tsalary); //Adding Salary TextField to the JFrame

        // Labels Employee Details as Address
        JLabel address = new JLabel("Address"); //Creating a JLabel for Address
        address.setBounds(50,250,150,30); //Setting position and size of the Address label
        address.setFont(new Font("SAN_SERIF", Font.BOLD,20)); //Setting font of the Address label
        add(address); //Adding Address label to the JFrame

        //TextField to input address
        taddress= new JTextField(); //Creating a TextField to input address
        taddress.setBounds(200,250,150,30); //Setting position and size of the Address TextField
        taddress.setBackground(new Color(177,252,197)); //Setting background color of the Address TextField
        add(taddress); //Adding Address TextField to the JFrame

        // Labels Employee Details as Phone
        JLabel phone = new JLabel("Phone"); //Creating a JLabel for Phone number
        phone.setBounds(400,250,150,30); //Setting position and size of the Phone label
        phone.setFont(new Font("SAN_SERIF", Font.BOLD,20)); //Setting font of the Phone label
        add(phone); //Adding Phone label to the JFrame

        //TextField to input phone number
        tphone= new JTextField(); //Creating a TextField to input phone number
        tphone.setBounds(600,250,150,30); //Setting position and size of the Phone TextField
        tphone.setBackground(new Color(177,252,197)); //Setting background color of the Phone TextField
        add(tphone); //Adding Phone TextField to the JFrame

        // Labels Employee Details as Email
        JLabel email = new JLabel("Email"); //  Creating a JLabel for Email address
        email.setBounds(50,300,150,30); //Setting position and size of the Email label
        email.setFont(new Font("SAN_SERIF", Font.BOLD,20)); //Setting font of the Email label
        add(email); //Adding Email label to the JFrame

        //TextField to input email
        temail= new JTextField(); //Creating a TextField to input email address
        temail.setBounds(200,300,150,30); //Setting position and size of the Email TextField
        temail.setBackground(new Color(177,252,197)); //Setting background color of the Email TextField
        add(temail); //Adding Email TextField to the JFrame

        // Labels Employee Details as Education
        JLabel education = new JLabel("Higest Education"); //Creating a JLabel for Highest Education
        education.setBounds(400,300,150,30); //Setting position and size of the Highest Education label
        education.setFont(new Font("SAN_SERIF", Font.BOLD,20)); //Setting font of the Highest Education label
        add(education); //Adding Highest Education label to the JFrame

        //TextField to input highest education
        teducation= new JTextField(); //Creating a TextField to input highest education
        teducation.setBounds(600,300,150,30); //Setting position and size of the Highest Education TextField
        teducation.setBackground(new Color(177,252,197)); //Setting background color of the Highest Education TextField
        add(teducation); //Adding Highest Education TextField to the JFrame

        // Labels Employee Details as Aadhar Number
        JLabel aadhar = new JLabel("Aadhar Number"); //Creating a JLabel for Aadhar Number
        aadhar.setBounds(400,350,150,30); //Setting position and size of the Aadhar Number label
        aadhar.setFont(new Font("SAN_SERIF", Font.BOLD,20)); //Setting font of the Aadhar Number label
        add(aadhar); //Adding Aadhar Number label to the JFrame

        //TextField to display aadhar number
        JLabel taadhar = new JLabel(); //Creating a TextField to display aadhar number
        taadhar.setBounds(600,350,150,30); //Setting position and size of the Aadhar Number display label
        taadhar.setBackground(new Color(177,252,197)); //Setting background color of the Aadhar Number display label
        add(taadhar); //Adding Aadhar Number display label to the JFrame

        // Labels Employee Details as Employee ID
        JLabel empid = new JLabel("Employee ID"); //Creating a JLabel for Employee ID
        empid.setBounds(50,400,150,30); //Setting position and size of the Employee ID label
        empid.setFont(new Font("SAN_SERIF", Font.BOLD,20)); //Setting font of the Employee ID label
        add(empid); //Adding Employee ID label to the JFrame

        //Label to display employee ID
        tempid= new JLabel(); //Creating a Label to display employee ID
        tempid.setBounds(200,400,150,30); // Setting position and size of the Employee ID display label
        tempid.setFont(new Font("SAN_SARIF", Font.BOLD,20)); //Setting font of the Employee ID display label
        tempid.setForeground(Color.RED); // Setting text color of the Employee ID display label to red
        add(tempid); //Adding Employee ID display label to the JFrame

        // Labels Employee Details as Designation
        JLabel designation = new JLabel("Designation"); //Creating a JLabel for Designation
        designation.setBounds(50,350,150,30); //Setting position and size of the Designation label
        designation.setFont(new Font("SAN_SERIF", Font.BOLD,20)); //Setting font of the Designation label
        add(designation); //Adding Designation label to the JFrame

        //TextField to input designation
        tdesignation= new JTextField(); //Creating a TextField to input designation
        tdesignation.setBounds(200,350,150,30); //Setting position and size of the Designation TextField
        tdesignation.setBackground(new Color(177,252,197)); //Setting background color of the Designation TextField
        add(tdesignation); //Adding Designation TextField to the JFrame

        // Fetch and populate employee details from the database
        try //Try-Catch block for exception handling
        {
            conn c = new conn(); //Creating an instance of conn class to establish database connection
            String query = "select * from employee where empId = '"+number+"'"; //SQL query to fetch employee details based on employee ID
            ResultSet resultSet = c.statement.executeQuery(query); //Executing the SQL query and getting the result set
            while (resultSet.next()) //Iterating through the result set to get employee details
            {
                tname.setText(resultSet.getString("name")); //Setting employee name in the Name display label
                tsurname.setText(resultSet.getString("surname")); //Setting father's name in the Father's Name TextField
                tdob.setText(resultSet.getString("dob")); //Setting date of birth in the Date of Birth display label
                taddress.setText(resultSet.getString("address")); //Setting address in the Address TextField
                tsalary.setText(resultSet.getString("salary")); //Setting salary in the Salary TextField
                tphone.setText(resultSet.getString("phone")); //Setting phone number in the Phone Number TextField
                temail.setText(resultSet.getString("email")); //Setting email in the Email TextField
                teducation.setText(resultSet.getString("education")); //Setting education in the Education TextField
                taadhar.setText(resultSet.getString("aadhar")); //Setting Aadhar number in the Aadhar Number display label
                tempid.setText(resultSet.getString("empId")); //Setting employee ID in the Employee ID display label
                tdesignation.setText(resultSet.getString("designation")); //Setting designation in the Designation TextField
            }
        }
        catch (Exception e) //Catch block to handle exceptions
        {
            e.printStackTrace(); //Prints the stack trace of the exception for debugging
        }

        // Add Button to update employee details
        add = new JButton("UPDATE"); //Creating a JButton for Update action
        add.setBounds(450,550,150,40); //Setting position and size of the Update button
        add.setBackground(Color.black); //Setting background color of the Update button to black
        add.setForeground(Color.WHITE); //Setting text color of the Update button to white
        add.addActionListener(this); //Adding ActionListener to the Update button
        add(add); //Adding Update button to the JFrame

        // Back Button to return to previous screen
        back = new JButton("BACK"); //Creating a JButton for Back action
        back.setBounds(250,550,150,40); //Setting position and size of the Back button
        back.setBackground(Color.black); //Setting background color of the Back button to black
        back.setForeground(Color.WHITE); //Setting text color of the Back button to white
        back.addActionListener(this); //Adding ActionListener to the Back button
        add(back); //Adding Back button to the JFrame

        //JFrame settings
        setSize(900,700); //Setting size of the JFrame
        setLayout(null); //No layout manager
        setLocation(300,50); //Setting location of the JFrame
        setVisible(true); //Making the JFrame visible
    }

    // ActionListener method to handle button clicks and overrides actionPerformed method
    @Override
    public void actionPerformed(ActionEvent e) // Method to handle button click events by the user by implementing ActionListener or overriding actionPerformed method
    {
        if (e.getSource() == add) //If Update button is clicked
        {
            String surname = tsurname.getText(); //Getting father's name from the TextField
            String salary = tsalary.getText(); //Getting salary from the TextField
            String address = taddress.getText(); //Getting address from the TextField
            String phone = tphone.getText(); //Getting phone number from the TextField
            String email = temail.getText(); //Getting email from the TextField
            String education = teducation.getText(); //Getting education from the TextField
            String designation = tdesignation.getText(); //Getting designation from the TextField

            // Update employee details in the database
            try //Try-Catch block for exception handling
            {
                conn c = new conn(); //Creating an instance of conn class to establish database connection
                String query = "update employee set surname = '"+surname+"', salary = '"+salary+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"', education = '"+education+"', designation = '"+designation+"' where empId = '"+number+"'"; //SQL query to update employee details based on employee ID
                c.statement.executeUpdate(query); //Executing the SQL update query
                JOptionPane.showMessageDialog(null, "Details updated successfully"); //Showing success message dialog to the user
                setVisible(false); //Hiding the current window
                new Main_Class(); //Opening Main Class window and creating its instance
            }
            catch (Exception E) //Catch block to handle exceptions
            {
                E.printStackTrace(); //Prints the stack trace of the exception for debugging
            }
        }
        else //If Back button is clicked
        {
            setVisible(false); //Hiding the current window
            new View_Employee(); //Opening View Employee window and creating its instance
        }
    }

    public static void main(String[] args)
    {
        new Update_Employee(""); //Creating an instance of Update_Employee to display the window
    }
}