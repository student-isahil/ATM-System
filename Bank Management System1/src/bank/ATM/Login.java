package bank.management.system1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, signup, clear;
    JTextField cardField;
    JPasswordField pTextField;
 
    Login()
    {
        setLayout(null);
        setTitle("Automated Teller Machine");

        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icon1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(60,10,100,100);
        add(label);
        
        JLabel text = new JLabel("Welcom To ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(220,40,400,50);
        add(text);
        
        JLabel Cardno = new JLabel("Card No: ");
        Cardno.setFont(new Font("Raleway",Font.BOLD,28));
        Cardno.setBounds(120,150,250,30);
        add(Cardno);
        
        cardField = new JTextField();
        cardField.setFont(new Font("Raleway",Font.BOLD,14));
        cardField.setBounds(300,150,230,30);
        add(cardField);
        
        JLabel Pin = new JLabel("PIN:");
        Pin.setFont(new Font("Raleway",Font.BOLD,28));
        Pin.setBounds(120,220,250,30);
        add(Pin);
        
        pTextField = new JPasswordField();
        pTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pTextField.setBounds(300,220,230,30);
        add(pTextField);
        
        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
        getContentPane().setBackground(Color.WHITE);
    }
    
    
   public void actionPerformed(ActionEvent ac)
   {
     if(ac.getSource() == clear)
     {
        cardField.setText("");
        pTextField.setText("");
     }   
     else if(ac.getSource() == login)
     {
         Conn c = new Conn();
         String cardno = cardField.getText();
         String pin = pTextField.getText();
         
         String query = "select * from login where CardNumber = '"+cardno+"' and Pin = '"+pin+"'  ";
         
         try
         {
             ResultSet r = c.s.executeQuery(query);  // DDL Command
             if(r.next())
             {
                 setVisible(false);
                 new transaction(pin).setVisible(true);
             }
             else JOptionPane.showMessageDialog(null, "Incorrect Cardno. or Pin! ");
         }
         catch(Exception e)
         {
            System.out.print(e);
         }
         
     }
     else if(ac.getSource() == signup)
     {
         setVisible(false);
         new SignOne().setVisible(true);
     }
   }

  
    
    
    public static void main(String[] args) 
    {
     
        new Login();
    }
    
}

