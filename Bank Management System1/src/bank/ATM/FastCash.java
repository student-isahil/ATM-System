
package bank.management.system1;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener
{
    JButton a1,a2,a3,a4,a5,a6,a7;
    String pin;
    
    FastCash(String pin)
    {
        this.pin = pin;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(870,870, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,870,870);
        add(image);
        
        JLabel text = new JLabel("SELECT  WITHDRAWL  AMOUNT");
        text.setForeground(Color.WHITE);
        text.setBounds(210,320,400,20);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        a1 = new JButton("Rs 100");
        a1.setBounds(180,450,130,28);
        a1.addActionListener(this);
        image.add(a1);
        
        a2 = new JButton("Rs 500");
        a2.setBounds(360,450,130,28);
        a2.addActionListener(this);
        image.add(a2);
        
       a3 = new JButton("Rs 1000");
       a3.setBounds(180,487,130,28);
       a3.addActionListener(this);
       image.add(a3);
        
        a4 = new JButton("Rs 2000");
        a4.setBounds(360,487,130,28);
        a4.addActionListener(this);
        image.add(a4);
        
        a5 = new JButton("Rs 5000");
        a5.setBounds(180,525,130,28);
        a5.addActionListener(this);
        image.add(a5);
        
       a6 = new JButton("Rs 10000");
       a6.setBounds(360,525,130,28);
       a6.addActionListener(this);
        image.add(a6);
        
       a7 = new JButton("Back");
       a7.setBounds(360,560,130,28);
       a7.addActionListener(this);
       image.add(a7);
        
        
        
        
        setSize(900,900);
        setLocation(350,10);
        setUndecorated(true);
        setVisible(true);
        
    }
    
     public void actionPerformed(ActionEvent ac)
    {
       if(ac.getSource() == a7)
        {
            setVisible(false);
            new transaction(pin).setVisible(true);
        }
       else
       {
           String amount = ((JButton)ac.getSource()).getText().substring(3);
           Conn c = new Conn();
           {
                try
                {
                   ResultSet r = c.s.executeQuery("select * from bank where pin = '"+pin+"' ");
                   int balance = 0;
                   while(r.next())
                   {
                       if(r.getString("type").equals("Deposit")) balance += Integer.parseInt(r.getString("amount"));
                       else  balance -= Integer.parseInt(r.getString("amount"));
                   }
                   
                   if(ac.getSource() != a7 && balance < Integer.parseInt(amount)) 
                   {
                       JOptionPane.showMessageDialog(null,"Insufficient Balance!");
                       return;
                   }
                   
                   Date date = new Date();
                   String query = "insert into bank values ('"+pin+"' ,'"+date+"' , 'withdrawl', '"+amount+"' )";
                   c.s.executeUpdate(query);
                   
                   JOptionPane.showMessageDialog(null,"Rs " +amount+ " Debited Successfully ");
                   
                   setVisible(false);
                   new transaction(pin).setVisible(true);
                   
                   
                }
                catch(Exception e)
                {
                   System.out.print(e);
                }
           }
       }
    }
    
    
     public static void main(String args[])
    {
        new FastCash("");  
    }
}
