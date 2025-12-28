package employee.management.system; //Package declaration

import java.sql.Connection; //For Connection class to establish connection with the database
import java.sql.DriverManager; //For DriverManager class to manage JDBC drivers and establish connections
import java.sql.Statement; //For Statement class to execute SQL queries

public class conn { //Database connection class

    Connection connection; //Connection object to establish connection with the database
    Statement statement; //Statement object to execute SQL queries

    public conn() { //Constructor to initialize the connection and statement objects
        try //Try-Catch block for exception handling
        {
            //Loading the JDBC driver for MySQL
            Class.forName("com.mysql.cj.jdbc.Driver"); //Updated driver class name

            //Establishing connection to the database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement", "root", "Pass@123"); //Database URL, username, and password

            //Creating a Statement object to execute SQL queries
            statement = (Statement) connection.createStatement(); //Casting to Statement type
        }
        catch (Exception e) //Catch block to handle exceptions
        {
            e.printStackTrace(); //Prints the stack trace of the exception for debugging
        }
    }
}