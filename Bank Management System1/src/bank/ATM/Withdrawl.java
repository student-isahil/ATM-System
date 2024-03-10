
package bank.management.system1;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener
{
    JTextField amount;
    JButton withdrawl,back;
    String pin;
    
    Withdrawl(String pin)
    {
        setLayout(null);
        this.pin = pin;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(870,870, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,870,870);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setForeground(Color.WHITE);
        text.setBounds(180,300,400,20);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(170,350,315,25);
        image.add(amount);
        
        withdrawl = new JButton("Withdrawl");
        withdrawl.setBounds(355,507,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
       back = new JButton("Back");
       back.setBounds(355,545,150,30);
       back.addActionListener(this);
       image.add(back);
        
        
        setSize(900,900);
        setLocation(350,10);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ac)
    {
        if(ac.getSource() == withdrawl)
        {
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")) JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdrawl! ");
            else
            {
                try
                {
                   Conn c = new Conn();
                   String query = "insert into bank values ('"+pin+"', '"+date+"' , 'Withdrawl' , '"+number+"') ";
                   c.s.executeUpdate(query);
                   JOptionPane.showMessageDialog(null, "Rs " +number+ " Withdrawl Successfully ");
                   setVisible(false);
                   new transaction(pin).setVisible(true);
                }
                catch(Exception e)
                {
                   System.out.print(e);
                }
                
            }
        }
        else if(ac.getSource() == back)
        {
            setVisible(false);
            new transaction(pin).setVisible(true);
        }
    }
    
    
    public static void main(String args[])
    {
        new Withdrawl("");   
    }
}
