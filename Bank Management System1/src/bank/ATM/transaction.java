
package bank.management.system1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class transaction  extends JFrame implements ActionListener
{
    JButton deposit, cashwithdrawl,fastcash,statement,pinchange,balance,exit;
    String pin;
    transaction(String pin)
    {
        setLayout(null);
        this.pin = pin;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(180,280,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(text);
        

        deposit = new JButton("Deposit");
        deposit.setBounds(150,400,130,28);
        deposit.addActionListener(this);
        image.add(deposit);
        
        cashwithdrawl = new JButton("Cash Withdrawl");
        cashwithdrawl.setBounds(320,400,130,28);
        cashwithdrawl.addActionListener(this);
        image.add(cashwithdrawl);
        
       fastcash = new JButton("Fast Cash");
       fastcash.setBounds(150,435,130,28);
       fastcash.addActionListener(this);
       image.add(fastcash);
        
        statement = new JButton("Mini Statement");
        statement.setBounds(320,435,130,28);
        statement.addActionListener(this);
        image.add(statement);
        
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(150,468,130,28);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balance = new JButton("Balance Enquiry");
        balance.setBounds(320,468,130,28);
        balance.addActionListener(this);
        image.add(balance);
        
       exit = new JButton("Exit");
       exit.setBounds(320,500,130,28);
       exit.addActionListener(this);
       image.add(exit);
        
        setSize(800,800);
        setLocation(360,150);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ac)
    {
        
        if(ac.getSource() == exit) { System.exit(0); }
        else if(ac.getSource() == deposit)
        {
            setVisible(false);
            new Deposit(pin).setVisible(true);
        }
        else if(ac.getSource() == cashwithdrawl)
        {
            setVisible(false);
            new Withdrawl(pin).setVisible(true);
        }
        else if(ac.getSource() == fastcash)
        {
            setVisible(false);
            new FastCash(pin).setVisible(true);
        }
        else if(ac.getSource() == pinchange)
        {
            setVisible(false);
            new PinChange(pin).setVisible(true);
        }
         else if(ac.getSource() == balance)
        {
            setVisible(false);
            new  BalanceEnquiry(pin).setVisible(true);
        }
        else if(ac.getSource() == statement)
        {
            new  MiniStatement(pin).setVisible(true);
        }
        
        
    }
    
    
    
    public static void main(String args[])
    {
        new transaction("");
    }
}
