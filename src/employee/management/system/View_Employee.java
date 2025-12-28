package employee.management.system; // Package declaration and organization

import java.awt.*; // For GUI components like Color, Font, Choice etc.
import java.awt.event.*; // For ActionEvent and ActionListener handling
import java.sql.*; // For SQL classes like Connection, ResultSet etc.
import javax.swing.*; // For Swing components like JFrame, JButton, JLabel, JTable etc.
import javax.swing.table.DefaultTableModel; // For DefaultTableModel to manage table data and structure

public class View_Employee extends JFrame implements ActionListener // View Employee class extending JFrame and implementing ActionListener
{

    //Table to display employee data
    JTable table; // JTable to display employee data

    //Choice dropdown for employee IDs
    Choice choiceEMP; // Choice component for selecting employee IDs

    // Buttons for actions like Search, Print, Update, Back
    JButton searchbtn, print, update, back; // JButton components for various actions
    
    //DefaultTableModel for managing table data and structure
    DefaultTableModel model; // DefaultTableModel to manage table data and structure

    //Constructor
    View_Employee()
    {
        //Setting up the JFrame properties
        getContentPane().setBackground(new Color(255, 131, 122)); //Setting background color of the JFrame
        setLayout(null); //No layout manager

        //Label for Search by Employee ID
        JLabel search = new JLabel("Search by employee id"); //Creating a JLabel for search instruction
        search.setBounds(20, 20, 150, 20); //Setting position and size of the label
        add(search); //Adding label to the JFrame

        //Choice component for Employee IDs dropdown
        choiceEMP = new Choice();   //Creating a Choice component for employee IDs dropdown
        choiceEMP.setBounds(180, 20, 150, 20); //Setting position and size of the Choice component
        add(choiceEMP); //Adding Choice component to the JFrame

        // Initialize Table Model for Java 21 compatibility
        String[] columnNames = {"Name", "Surname", "DOB", "Salary", "Address", "Phone", "Email", "Education", "Aadhar", "Designation", "Emp ID"}; // Column names for the table
        model = new DefaultTableModel(columnNames, 0); // Initializing DefaultTableModel with column names and 0 rows
        table = new JTable(model); // Initializing JTable with the model

        // Initial data load and populate choiceEMP
        updateTable("select * from employee", true); // Load all employee data and populate choiceEMP

        //Scroll pane for the table
        JScrollPane jp = new JScrollPane(table); //Creating a JScrollPane to hold the JTable
        jp.setBounds(0, 100, 900, 600); //Setting position and size of the scroll pane
        add(jp); //Adding scroll pane to the JFrame

        //Buttons initialization and configuration for Search
        searchbtn = new JButton("Search"); //Creating a JButton for Search action
        searchbtn.setBounds(20, 70, 80, 20); //Setting position and size of the Search button
        searchbtn.addActionListener(this); //Adding ActionListener to the Search button
        add(searchbtn); //Adding Search button to the JFrame

        //Buttons initialization and configuration for Print
        print = new JButton("Print"); //Creating a JButton for Print action
        print.setBounds(120, 70, 80, 20); //Setting position and size of the Print button
        print.addActionListener(this); //Adding ActionListener to the Print button
        add(print); //Adding Print button to the JFrame

        //Buttons initialization and configuration for Update
        update = new JButton("Update"); //Creating a JButton for Update action
        update.setBounds(220, 70, 80, 20); //Setting position and size of the Update button
        update.addActionListener(this); //Adding ActionListener to the Update button
        add(update); //Adding Update button to the JFrame

        //Buttons initialization and configuration for Back
        back = new JButton("Back"); //Creating a JButton for Back action
        back.setBounds(320, 70, 80, 20); //Setting position and size of the Back button
        back.addActionListener(this); //Adding ActionListener to the Back button
        add(back); //Adding Back button to the JFrame

        //JFrame settings
        setSize(900, 700); //Setting size of the JFrame
        setLocation(300, 100); //Setting location of the JFrame
        setVisible(true); //Making the JFrame visible
    }

    // Helper method to update table data manually (replaces DbUtils) and populate choiceEMP
    public void updateTable(String query, boolean isFirstLoad)  // Method to update table data based on SQL query
    {
        try //Try-Catch block for exception handling
        {
            conn c = new conn(); //Creating an instance of conn class to establish database connection
            ResultSet rs = c.statement.executeQuery(query); //Executing the SQL query and getting the result set
            model.setRowCount(0); // Clear table and repopulate
            
            while (rs.next()) //Iterating through the result set
            {
                Object[] row = // Creating a row object to hold employee data
                {
                    rs.getString("name"), rs.getString("surname"), rs.getString("dob"), // Match database: name, fname, dob
                    rs.getString("salary"), rs.getString("address"), rs.getString("phone"), // Match database: salary, address, phone
                    rs.getString("email"), rs.getString("education"), // Match database: email, education
                    rs.getString("aadhar"), // Match database: aadhar
                    rs.getString("designation"), // Match database: designation
                    rs.getString("empID")   // Match database: empID
                };
                model.addRow(row); // Adding the row to the table model
                if (isFirstLoad) // Populate choiceEMP only on first load
                {
                    choiceEMP.add(rs.getString("empID")); // Adding employee ID to the Choice component
                }
            }
        }
        catch (Exception e) //Catch block to handle exceptions
        {
            e.printStackTrace(); //Prints the stack trace of the exception for debugging
        }
    }

    // ActionListener method to handle button clicks Override
    @Override
    public void actionPerformed(ActionEvent e) // Method to handle button click events by the user by implementing ActionListener or overriding actionPerformed method
    {
        if (e.getSource() == searchbtn) //If Search button is clicked
        {
            String query = "select * from employee where empID = '" + choiceEMP.getSelectedItem() + "'"; //SQL query to fetch employee data based on selected employee ID
            updateTable(query, false); // Update table with search results without repopulating choiceEMP
        }
        else if (e.getSource() == print) //If Print button is clicked
        {
            try //Try-Catch block for exception handling
            {
                table.print(); //Printing the JTable data
            }
            catch (Exception ex) //Catch block to handle exceptions
            {
                ex.printStackTrace(); //Prints the stack trace of the exception for debugging
            }
        }
        else if (e.getSource() == update) //If Update button is clicked
        {
            setVisible(false); //Hiding the current window
            new Update_Employee(choiceEMP.getSelectedItem()); //Opening Update Employee window with selected employee ID and creating its instance
        }
        else //If Back button is clicked
        {
            setVisible(false); //Hiding the current window
            new Main_Class(); //Opening Main Class window and creating its instance
        }
    }

    public static void main(String[] args)
    {
        new View_Employee(); //Creating an instance of View_Employee to display the window
    }
}