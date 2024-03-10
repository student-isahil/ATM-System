
package bank.management.system1;

import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class MiniStatement   extends JFrame 
{
    String pin;
    
     MiniStatement(String pin)
     {
         this.pin = pin;
         
        setLayout(null);
        setTitle("Mini Statement");
        
        JLabel mini = new JLabel();
        add(mini);
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        JLabel Balance = new JLabel();
        Balance.setBounds(20,400,300,20);
        add(Balance);
        
        try
        {
            Conn c = new Conn();
            ResultSet r = c.s.executeQuery("select * from login where pin = '"+pin+"' ");
            while(r.next())
            {
                card.setText("Card Number:  " +r.getString("CardNumber").substring(0,4) + "-XXXX-XXXX-" + r.getString("CardNumber").substring(12)) ;
            }
            
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
        
        try
        {
            Conn c = new Conn();
            ResultSet r = c.s.executeQuery("select * from bank where pin = '6000' ");
            int balance = 0;
            while(r.next())
            {
                mini.setText(mini.getText() + "<html>" + r.getString("date")  + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ r.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +r.getString("amount")  + "<br><br><html>");
                if(r.getString("type").equals("Deposit")) balance += Integer.parseInt(r.getString("amount"));
                else  balance -= Integer.parseInt(r.getString("amount"));
            }
            Balance.setText("Your current account balance is Rs " + balance);
            
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
        mini.setBounds(20,140,400,200);
        
        
        
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
     }
     
    
    public static void main(String args[])
    {
                new MiniStatement("");
    }
}
