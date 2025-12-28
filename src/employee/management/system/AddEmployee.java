package employee.management.system; //Package declaration

import java.awt.*; //For GUI components like Color, Font etc.
import java.awt.event.ActionEvent; //For ActionEvent handling
import java.awt.event.ActionListener; //For ActionListener interface
import java.awt.event.FocusAdapter; //For FocusAdapter to handle focus events on TextFields
import java.awt.event.FocusEvent; //For FocusEvent handling
import java.util.Random; //For generating random employee ID numbers
import javax.swing.*; //For Swing components like JFrame, JButton, JLabel, JTextField, JComboBox etc.

public class AddEmployee extends JFrame implements ActionListener
{

    //Globally declaring variables of TextFields and ComboBox
    JTextField tname, tsurname, taddress, tphone, taadhar, temail, tsalary, tdesignation; //TextFields for employee details

    //Globally declaring JButtons
    JButton add, back; //Buttons for adding employee and going back
    
    JComboBox Boxeducation; //ComboBox or Dropdown for education qualification

    //Random number generate for employee id
    Random ran = new Random(); //Random object to generate random numbers
    int number = ran.nextInt(999999); //Generating a random number between 0 to 999999 having limit of 6 digits

    //date of birth TextField Calendar
    JTextField tdob = new JTextField();

    //Employee ID display
    JLabel tempid; //Label to display generated employee id

    //Constructor
    AddEmployee()
    {
        //Setting background color of the JFrame
        getContentPane().setBackground(new Color(163, 255, 188)); //Setting background color of the AddEmployee window

        //Add Employee Details Label
        JLabel heading = new JLabel("Add Employee Details"); //Creating a JLabel for heading
        heading.setBounds(320, 30, 500, 50); //Setting position and size of the heading
        heading.setFont(new Font("serif", Font.BOLD, 25)); //Setting font size of the heading
        add(heading); //Adding heading to the JFrame

        //Name Label
        JLabel name = new JLabel("Name:"); //Creating a JLabel for name
        name.setBounds(50, 150, 150, 30); //Setting position and size of the label
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20)); //Setting font size of the label
        add(name); //Adding label to the JFrame

        //Name TextField
        tname = new JTextField(); //Creating a TextField for name input
        tname.setBounds(200, 150, 150, 30); //Setting position and size of the TextField
        tname.setBackground(new Color(177, 252, 197)); //Setting background color of the TextField
        add(tname); //Adding TextField to the JFrame

        //Father's Name Label
        JLabel surname = new JLabel("Surname:"); //Creating a JLabel for father's name
        surname.setBounds(400, 150, 150, 30); //Setting position and size of the label
        surname.setFont(new Font("SAN_SERIF", Font.BOLD, 20)); //Setting font size of the label
        add(surname); //Adding label to the JFrame

        //Father's Name TextField
        tsurname = new JTextField(); //Creating a TextField for father's name input
        tsurname.setBounds(600, 150, 150, 30); //Setting position and size of the TextField
        tsurname.setBackground(new Color(177, 252, 197)); //Setting background color of the TextField
        add(tsurname); //Adding TextField to the JFrame

        //Date of Birth Label
        JLabel dob = new JLabel("Date of Birth:"); //Creating a JLabel for date of birth
        dob.setBounds(50, 200, 150, 30); //Setting position and size of the label
        dob.setFont(new Font("SAN_SERIF", Font.BOLD, 20)); //Setting font size of the label
        add(dob); //Adding label to the JFrame

        //Date of Birth TextField
        tdob = new JTextField("dd/MM/yyyy"); //Creating a TextField for date of birth input
        tdob.setBounds(200, 200, 150, 30); //Setting position and size of the label
        tdob.setBackground(new Color(177, 252, 197)); //Setting background color of the label
        add(tdob); //Adding label to the JFrame

        // Clear placeholder on focus and restore if empty on focus lost
        tdob.addFocusListener(new FocusAdapter() { //Anonymous Inner Class
            @Override
            public void focusGained(FocusEvent e) //Overriding focusGained method
            {
                if (tdob.getText().equals("dd/MM/yyyy")) //Placeholder text
                {
                    tdob.setText(""); //Clear placeholder
                }
            }
            @Override
            public void focusLost(FocusEvent e) //Overriding focusLost method
            {
                if (tdob.getText().isEmpty()) //If TextField is empty
                {
                    tdob.setText("dd/MM/yyyy"); //Restore placeholder
                }
            }
        });

        //Salary Label
        JLabel salary = new JLabel("Salary:"); //Creating a JLabel for salary
        salary.setBounds(400, 200, 150, 30); //Setting position and size of the label
        salary.setFont(new Font("SAN_SERIF", Font.BOLD, 20)); //Setting font size of the label
        add(salary); //Adding label to the JFrame

        //Salary TextField
        tsalary = new JTextField(); //Creating a TextField for salary input
        tsalary.setBounds(600, 200, 150, 30); //Setting position and size of the TextField
        tsalary.setBackground(new Color(177, 252, 197)); //Setting background color of the TextField
        add(tsalary); //Adding TextField to the JFrame

        //Address Label
        JLabel address = new JLabel("Address:"); //Creating a JLabel for address
        address.setBounds(50, 250, 150, 30); //Setting position and size of the label
        address.setFont(new Font("SAN_SERIF", Font.BOLD, 20)); //Setting font size of the label
        add(address); //Adding label to the JFrame

        //Address TextField
        taddress = new JTextField(); //Creating a TextField for address input
        taddress.setBounds(200, 250, 150, 30); //Setting position and size of the TextField
        taddress.setBackground(new Color(177, 252, 197)); //Setting background color of the TextField
        add(taddress); //Adding TextField to the JFrame

        //Phone number Label
        JLabel phone = new JLabel("Phone Number:"); //Creating a JLabel for phone number
        phone.setBounds(400, 250, 150, 30); //Setting position and size of the label
        phone.setFont(new Font("SAN_SERIF", Font.BOLD, 20)); //Setting font size of the label
        add(phone); //Adding label to the JFrame
        
        //Phone number TextField
        tphone = new JTextField(); //Creating a TextField for phone number input
        tphone.setBounds(600, 250, 150, 30); //Setting position and size of the TextField
        tphone.setBackground(new Color(177, 252, 197)); //Setting background color of the TextField
        add(tphone); //Adding TextField to the JFrame

        //Email Label
        JLabel email = new JLabel("Email:"); //Creating a JLabel for email
        email.setBounds(50, 300, 150, 30); //Setting position and size of the label
        email.setFont(new Font("SAN_SERIF", Font.BOLD, 20)); //Setting font size of the label
        add(email); //Adding label to the JFrame
        
        //Email TextField
        temail = new JTextField(); //Creating a TextField for email input
        temail.setBounds(200, 300, 150, 30); //Setting position and size of the TextField
        temail.setBackground(new Color(177, 252, 197)); //Setting background color of the TextField
        add(temail); //Adding TextField to the JFrame

        //Education Label
        JLabel education = new JLabel("Highest Education:"); //Creating a JLabel for education
        education.setBounds(400, 300, 150, 30); //Setting position and size of the label
        education.setFont(new Font("SAN_SERIF", Font.BOLD, 20)); //Setting font size of the label
        add(education); //Adding label to the JFrame

        //Dropdown for Education
        String educationOptions[] = {"High School", "Intermediate", "Graduation",
                                    "Post Graduation", "Doctorate", "BBA", "B.Tech",
                                    "BCA", "BA", "BSC","B.COM", "MBA", "MCA",
                                    "MA", "M.Tech", "MSC", "PHD"}; //Array of education options
        Boxeducation = new JComboBox(educationOptions); //Creating a ComboBox with education options
        Boxeducation.setBounds(600, 300, 150, 30); //Setting position and size of the ComboBox
        Boxeducation.setBackground(new Color(177, 252, 197)); //Setting background color of the ComboBox
        add(Boxeducation); //Adding ComboBox to the JFrame

        //Aadhar Label
        JLabel aadhar = new JLabel("Aadhar No.:"); //Creating a JLabel for Aadhar number
        aadhar.setBounds(400, 350, 150, 30); //Setting position and size of the label
        aadhar.setFont(new Font("SAN_SERIF", Font.BOLD, 20)); //Setting font size of the label
        add(aadhar); //Adding label to the JFrame

        //Aadhar TextField
        taadhar = new JTextField(); //Creating a TextField for Aadhar number input
        taadhar.setBounds(600, 350, 150, 30); //Setting position and size of the TextField
        taadhar.setBackground(new Color(177, 252, 197)); //Setting background color of the TextField
        add(taadhar); //Adding TextField to the JFrame

        //Employee ID Label
        JLabel empid = new JLabel("Employee ID"); //Creating a JLabel for employee id
        empid.setBounds(50,400,150,30); //Setting position and size of the label
        empid.setFont(new Font("SAN_SERIF", Font.BOLD,20)); //Setting font size of the label
        add(empid); //Adding label to the JFrame

        //Employee ID Display Label
        tempid= new JLabel("" + number); //Creating a JLabel to display generated employee id and converting int to String
        tempid.setBounds(200,400,150,30); //Setting position and size of the label
        tempid.setFont(new Font("SAN_SERIF", Font.BOLD,20)); //Setting font size of the label
        tempid.setForeground(Color.RED); //Setting text color of the label
        add(tempid);

        //Designation Label
        JLabel designation = new JLabel("Designation:"); //Creating a JLabel for designation
        designation.setBounds(50, 350, 150, 30); //Setting position and size of the label
        designation.setFont(new Font("SAN_SERIF", Font.BOLD, 20)); //Setting font size of the label
        add(designation); //Adding label to the JFrame

        //Designation TextField
        tdesignation = new JTextField(); //Creating a TextField for designation input
        tdesignation.setBounds(200, 350, 150, 30); //Setting position and size of the TextField
        tdesignation.setBackground(new Color(177, 252, 197)); //Setting background color of the TextField
        add(tdesignation); //Adding TextField to the JFrame

        //Add Button
        add = new JButton("Add Details"); //Creating a JButton for adding employee details
        add.setBounds(450, 550, 150, 40); //Setting position and size of the button
        add.setBackground(Color.BLACK); //Setting background color of the button
        add.setForeground(Color.WHITE); //Setting text color of the button
        add.addActionListener(this); //Adding ActionListener to the button
        add(add); //Adding button to the JFrame

        //Back Button
        back = new JButton("Back"); //Creating a JButton for going back
        back.setBounds(250, 550, 150, 40); //Setting position and size of the button
        back.setBackground(Color.BLACK); //Setting background color of the button
        back.setForeground(Color.WHITE); //Setting text color of the button
        back.addActionListener(this); //Adding ActionListener to the button
        add(back); //Adding button to the JFrame
    
        setSize(900, 750); //Setting size of the AddEmployee window
        setLayout(null); //No layout manager
        setLocation(300, 50); //Setting location of the AddEmployee window
        setVisible(true); //Making the AddEmployee window visible
    }

    //Overriding actionPerformed method to handle button clicks
    @Override
    public void actionPerformed(ActionEvent e) { //Overriding actionPerformed method
        if (e.getSource() == add) //If Add button is clicked
        {
            //Retrieving data from TextFields and ComboBox
            String name = tname.getText(); //Getting name from TextField
            String surname = tsurname.getText(); //Getting father's name from TextField
            String dob = tdob.getText(); //Getting date of birth from TextField
            String salary = tsalary.getText(); //Getting salary from TextField
            String address = taddress.getText(); //Getting address from TextField
            String phone = tphone.getText(); //Getting phone number from TextField
            String email = temail.getText(); //Getting email from TextField
            String education = (String) Boxeducation.getSelectedItem(); //Getting selected education from ComboBox and casting to String because we have used string for education options
            String aadhar = taadhar.getText(); //Getting Aadhar number from TextField
            String designation = tdesignation.getText(); //Getting designation from TextField
            String empid = tempid.getText(); //Getting generated employee id from Label

            //Inserting data into the database
            try //Try-Catch block for exception handling
            {
                conn connection = new conn(); //Creating a conn object to establish database connection
                //SQL query to insert employee details into the database
                String query = "INSERT INTO employee VALUES('" + name + "','" + surname + "','" + dob + "','" + salary + "','" + address + "','" + phone + "','" + email + "','" + education + "','" + aadhar + "','" + designation + "','" + empid + "')";
                connection.statement.executeUpdate(query); //Executing the SQL query

                JOptionPane.showMessageDialog(null, "Employee Details Added Successfully"); //Showing success message

                setVisible(false); //Hiding the AddEmployee window
                new Main_Class(); //Opening the main class window
            }
            catch (Exception E) //Catch block to handle exceptions
            {
                E.printStackTrace(); //Printing stack trace in case of exception
            }
        }
        else if (e.getSource() == back) //If Back button is clicked
        {
            setVisible(false); //Hiding the AddEmployee window
            new Main_Class(); //Opening the main class window
        }
    }
    public static void main(String[] args) {
        new AddEmployee(); //Creating an instance of AddEmployee class
    }
}