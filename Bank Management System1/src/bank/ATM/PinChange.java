
package bank.management.system1;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;



public class PinChange extends JFrame implements ActionListener
{
    String pin;
    JPasswordField newpin1,confirmpin1;
    JButton change,back;
    
    PinChange(String pin)
    {
         
        this.pin = pin;
        setLayout(null);
         
         
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(870,870, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,870,870);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setBounds(250,300,500,30);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        JLabel newpin = new JLabel("New Pin: ");
        newpin.setForeground(Color.WHITE);
        newpin.setBounds(165,360,180,30);
        newpin.setFont(new Font("System",Font.BOLD,16));
        image.add(newpin);
        
        newpin1 = new JPasswordField();
        newpin1.setForeground(Color.BLACK);
        newpin1.setBounds(280,360,200,30);
        newpin1.setFont(new Font("System",Font.BOLD,25));
        image.add(newpin1);
        
        JLabel confirmpin = new JLabel("Confirm Pin: ");
        confirmpin.setForeground(Color.WHITE);
        confirmpin.setBounds(165,400,180,30);
        confirmpin.setFont(new Font("System",Font.BOLD,16));
        image.add(confirmpin);
        
        confirmpin1 = new JPasswordField();
        confirmpin1.setForeground(Color.BLACK);
        confirmpin1.setBounds(280,400,200,30);
        confirmpin1.setFont(new Font("System",Font.BOLD,25));
        image.add(confirmpin1);
        
        change = new JButton("CHANGE");
        change.setBounds(355,510,150,30);
        change.addActionListener(this);
        image.add(change);
        
       back = new JButton("BACK");
       back.setBounds(355,540,150,30);
       back.addActionListener(this);
       image.add(back);
        

        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    
     public void actionPerformed(ActionEvent ac)
     {
         if(ac.getSource() == back)
         {
             setVisible(false);
             new transaction(pin).setVisible(true);
         }
         else
         {
             try
             {
                 String Npin = newpin1.getText();
                 String Cpin = confirmpin1.getText();
                 

                 
                 if(Npin.equals("")) 
                 {
                     JOptionPane.showMessageDialog(null," Please Enter New PIN ");
                     return;
                 }
                 
                 if(Cpin.equals("")) 
                 {
                     JOptionPane.showMessageDialog(null," Please Enter Confirm PIN ");
                     return;
                 }
                 
                 if(!Npin.equals(Cpin)) 
                 {
                     JOptionPane.showMessageDialog(null,"Entered PIN does not match! ");
                     return;
                 }
                 
                 Conn c = new Conn();
                 String query1 = "update bank set pin = '"+Npin+"' where pin = '"+pin+"' ";
                 String query2 = "update login set pin = '"+Npin+"' where pin = '"+pin+"' ";
                 String query3 = "update signupthree set pin = '"+Npin+"' where pin = '"+pin+"' ";
                 
                 c.s.executeUpdate(query1);
                 c.s.executeUpdate(query2);
                 c.s.executeUpdate(query3);
                 
                 JOptionPane.showMessageDialog(null," PIN changed successfully ");
                 
                 setVisible(false);
                 new transaction(Npin).setVisible(true);
                 
             }
             catch(Exception e)
             {
                System.out.print(e);
             }
       
         }
     }
     
      public static void main(String args[])
    {
        new PinChange("").setVisible(true);  
    }
}
