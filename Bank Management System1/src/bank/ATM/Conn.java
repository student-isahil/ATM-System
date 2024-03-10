package bank.management.system1;

import java.sql.*;


public class Conn 
{
    Connection c;
    Statement s;
    public Conn()
    {
        try
        {
          //  Class.forName(com.mysql.cj.jdbc.Driver);
            c = DriverManager.getConnection("jdbc:mysql:///BankManagementSystem", "root", "sahil@123");
            s = c.createStatement();
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
    }
    
}



