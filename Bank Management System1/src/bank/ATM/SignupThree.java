



package bank.management.system1;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;



public class SignupThree extends JFrame implements ActionListener {

 
    JButton cancel,submit;
    JRadioButton Account1,Account2,Account3,Account4;
    JCheckBox Services1,Services2, Services3, Services4, Services5, Services6,Services7;
    String formno;
    
    SignupThree(String formno)
    {
        this.formno = formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
        
        
        JLabel personal = new JLabel("Page 3: Account Details");
        personal.setBounds(290,80,400,30);
        personal.setFont(new Font("Raleway",Font.BOLD,22));
        add(personal);
        
        // Account Type
        JLabel Account = new JLabel("Account Type: ");
        Account.setBounds(100,140,160,30);
        Account.setFont(new Font("Raleway",Font.BOLD,20));
        add(Account);
        
        Account1 = new JRadioButton("Saving Account");
        Account1.setBounds(300,140,150,30);
        Account1.setFont(new Font("Raleway",Font.BOLD,16));
        Account1.setBackground(Color.WHITE);
        add(Account1);
        Account2 = new JRadioButton("Current Account");
        Account2.setBounds(530,140,170,30);
        Account2.setFont(new Font("Raleway",Font.BOLD,16));
        Account2.setBackground(Color.WHITE);
        add(Account2);
        Account3 = new JRadioButton("Fixed Deposit Account");
        Account3.setBounds(300,200,220,30);
        Account3.setFont(new Font("Raleway",Font.BOLD,16));
        Account3.setBackground(Color.WHITE);
        add(Account3);
        Account4 = new JRadioButton("Reccuring Deposit Account");
        Account4.setBounds(530,200,250,30);
        Account4.setFont(new Font("Raleway",Font.BOLD,16));
        Account4.setBackground(Color.WHITE);
        add(Account4);
        
        ButtonGroup b = new ButtonGroup();
        b.add(Account1);
        b.add(Account2);
        b.add(Account3);
        b.add(Account4);
        
        

        // Card Number
        JLabel cardno = new JLabel("Card Number: ");
        cardno.setFont(new Font("Raleway",Font.BOLD,22));
        cardno.setBounds(100,300,200,30);
        add(cardno);
        JLabel cardno1 = new JLabel("Your 16 Digit Card Number ");
        cardno1.setFont(new Font("Raleway",Font.BOLD,12));
        cardno1.setBounds(100,320,200,30);
        add(cardno1);
        JLabel cardno2 = new JLabel("XXXX-XXXX-XXXX-4851");
        cardno2.setFont(new Font("Raleway",Font.BOLD,22));
        cardno2.setBounds(300,300,250,30);
        add(cardno2);
        

        // Pin no.
        JLabel pin = new JLabel("PIN: ");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin);
        JLabel pin1 = new JLabel("Your 4 Digit Password");
        pin1.setFont(new Font("Raleway",Font.BOLD,12));
        pin1.setBounds(100,390,200,30);
        add(pin1);
        JLabel pin2 = new JLabel("XXXX ");
        pin2.setFont(new Font("Raleway",Font.BOLD,22));
        pin2.setBounds(300,370,200,30);
        add(pin2);
        

        
        //Services Required
        JLabel Services = new JLabel("Services Required: ");
       Services.setFont(new Font("Raleway",Font.BOLD,22));
       Services.setBounds(100,430,200,30);
        add(Services);
       Services1 = new JCheckBox("ATM Card");
       Services1.setBounds(300,430,120,30);
       Services1.setFont(new Font("Raleway",Font.BOLD,16));
       Services1.setBackground(Color.WHITE);
       add(Services1);
       Services2 = new JCheckBox("Internet Banking");
       Services2.setBounds(530,430,180,30);
       Services2.setFont(new Font("Raleway",Font.BOLD,16));
       Services2.setBackground(Color.WHITE);
       add(Services2);       
       Services3 = new JCheckBox("Mobile Banking");
       Services3.setBounds(300,490,150,30);
       Services3.setFont(new Font("Raleway",Font.BOLD,16));
       Services3.setBackground(Color.WHITE);
        add(Services3);
       Services4 = new JCheckBox("Email & Sms Alert");
       Services4.setBounds(530,490,180,30);
       Services4.setFont(new Font("Raleway",Font.BOLD,16));
       Services4.setBackground(Color.WHITE);
       add(Services4);
       Services5 = new JCheckBox("Cheque Book");
       Services5.setBounds(300,550,150,30);
       Services5.setFont(new Font("Raleway",Font.BOLD,16));
       Services5.setBackground(Color.WHITE);
       add(Services5);
       Services6 = new JCheckBox("E-Statement");
       Services6.setBounds(530,550,150,30);
       Services6.setFont(new Font("Raleway",Font.BOLD,16));
       Services6.setBackground(Color.WHITE);
       add(Services6);
       Services7 = new JCheckBox("I hereby decleares that the above entered details are correct to the best of my Knowledge");
       Services7.setBounds(300,610,600,30);
       Services7.setFont(new Font("Raleway",Font.BOLD,12));
       Services7.setBackground(Color.WHITE);
       add(Services7);
       
          
               
        
        // Button
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(620,660,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(400,660,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        
        
         
        
       setSize(850,800);
       setLocation(350,10);
       setVisible(true);
       getContentPane().setBackground(Color.WHITE);
    }
    
    public void actionPerformed(ActionEvent ac)
    {
        if(ac.getSource() == submit)
        {
          String AccountType = null;
          if(Account1.isSelected()) AccountType = "Saving Account";
          else if(Account2.isSelected()) AccountType = "Current Account";
          else if(Account3.isSelected()) AccountType = "Fixed Deposit Account";
          else if(Account4.isSelected()) AccountType = "Reccuring Deposit Account";
        
          Random random = new Random();
          String cardno = "" +  Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
        
          String pin = "" +  Math.abs((random.nextLong() % 9000L) + 1000L);
          
          String facility = "";
          if(Services1.isSelected()) facility = facility + " ATM Card";
          else if(Services2.isSelected()) facility = facility + " Internet Banking";
          else if(Services3.isSelected()) facility = facility + " Moblie Banking";
          else if(Services4.isSelected()) facility = facility + " Email & Sms Alerts";
          else if(Services5.isSelected()) facility = facility + " Cheque Book";
          else if(Services6.isSelected()) facility = facility + " E-Statement";
        
        
          try
          {
              if(AccountType.equals("")) JOptionPane.showMessageDialog(null, "Account Type is Required!");
              else
              {
                Conn c = new Conn();
                String query1 = "insert into signupThree values('"+formno+"',  '"+AccountType+"', '"+cardno+"', '"+pin+"', '"+ facility+"')";
                String query2 = "insert into login values('"+formno+"', '"+cardno+"', '"+pin+"')";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
             
                JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\n Pin: " + pin );
                
                setVisible(false);
                new Deposit(pin).setVisible(true);
              }
              
            
          }
          catch(Exception e)
          {
            System.out.print(e);
          }
          
        }
        
        else if(ac.getSource() == cancel)
        {
           setVisible(false);
           new Login().setVisible(true);
        }
        

        
      
    }
    public static void main(String args[])
    {

        new SignupThree("");
    }

}

