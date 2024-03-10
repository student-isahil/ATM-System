
package bank.management.system1;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener
{
      JButton back;
      String pin;
     
    BalanceEnquiry(String pin)
    {
        
        this.pin = pin;
        setLayout(null);
         
         
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(870,870, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,870,870);
        add(image);
        
       back = new JButton("BACK");
       back.setBounds(355,540,150,30);
       back.addActionListener(this);
       image.add(back);
       
        Conn c = new Conn();
        int balance = 0;
                
        try
        {
            ResultSet r = c.s.executeQuery("select * from bank where pin = '"+pin+"' ");
            while(r.next())
            {
                if(r.getString("type").equals("Deposit")) balance += Integer.parseInt(r.getString("amount"));
                else  balance -= Integer.parseInt(r.getString("amount"));
           }
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
        
        JLabel text = new JLabel("Your Current Account Balance is Rs " + balance);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        text.setBounds(190,300,400,30);
        image.add(text);
          
                   
       
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
     public void actionPerformed(ActionEvent ac)
     {

        setVisible(false);
        new  transaction(pin).setVisible(true);
   
     }
    
    
    public static void main(String args[])
    {
        new BalanceEnquiry("").setVisible(true);  
    }
           
}
