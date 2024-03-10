package bank.management.system1;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.*;
import java.awt.event.*;


public class SignOne extends JFrame implements ActionListener {

 
    long random;
    JTextField name1, father1, email1, add, city1, state1, pin;
    JButton next;
    JRadioButton male, female, married, unmarried, other;
    JDateChooser dateChooser;
    
    SignOne()
    {
        setLayout(null);
        
        Random r = new Random();
        random = Math.abs((r.nextLong() % 9000L)+ 1000L);
        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        JLabel personal = new JLabel("Page 1: Personal Deatails");
        personal.setBounds(290,80,400,30);
        personal.setFont(new Font("Raleway",Font.BOLD,22));
        add(personal);
        
        // NAME
        JLabel name = new JLabel("Name: ");
        name.setBounds(100,140,100,30);
        name.setFont(new Font("Raleway",Font.BOLD,20));
        add(name);
        name1 = new JTextField();
        name1.setFont(new Font("Raleway",Font.BOLD,14));
        name1.setBounds(300,140,400,30);
        add(name1);
        
        // Father Name
        JLabel father = new JLabel("Father's Name: ");
        father.setFont(new Font("Raleway",Font.BOLD,20));
        father.setBounds(100,190,200,30);
        add(father);
        father1 = new JTextField();
        father1.setFont(new Font("Raleway",Font.BOLD,14));
        father1.setBounds(300,190,400,30);
        add(father1);
        
        // DOB
        JLabel dob = new JLabel("DOB: ");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(Color.WHITE);
        add(dateChooser);


        // Gender
        JLabel Gender = new JLabel("Gender: ");
        Gender.setFont(new Font("Raleway",Font.BOLD,20));
        Gender.setBounds(100,290,200,30);
        add(Gender);
        male = new JRadioButton("MALE");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);
        // Buttons
        female = new JRadioButton("FEMALE");
        female.setBounds(450,290,120,30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup gender = new ButtonGroup();
        gender.add(male);
        gender.add(female);
        
        
        // Email
        JLabel Email = new JLabel("Email: ");
        Email.setFont(new Font("Raleway",Font.BOLD,20));
        Email.setBounds(100,340,200,30);
        add(Email); 
        email1 = new JTextField();
        email1.setFont(new Font("Raleway",Font.BOLD,14));
        email1.setBounds(300,340,400,30);
        add(email1);
        
        // Stauts
        JLabel Marital_Status = new JLabel("Marital Status: ");
        Marital_Status.setFont(new Font("Raleway",Font.BOLD,20));
        Marital_Status.setBounds(100,390,200,30);
        add(Marital_Status);
        // Buttons
        married = new JRadioButton("MARRIED");
        married.setBounds(300,390,120,30);
        married.setBackground(Color.WHITE);
        add(married);
        unmarried = new JRadioButton("UNMARRIED");
        unmarried.setBounds(450,390,120,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        other = new JRadioButton("OTHER");
        other.setBounds(630,390,120,30);
        other.setBackground(Color.WHITE);
        add(other);
        ButtonGroup status = new ButtonGroup();
        status.add(married);
        status.add(unmarried);
        status.add(other);
        
        
        // Address
        JLabel Address = new JLabel("Address: ");
        Address.setFont(new Font("Raleway",Font.BOLD,20));
        Address.setBounds(100,440,200,30);
        add(Address);
        add = new JTextField();
        add.setFont(new Font("Raleway",Font.BOLD,14));
        add.setBounds(300,440,400,30);
        add(add);
        
        // City
        JLabel City = new JLabel("City: ");
        City.setFont(new Font("Raleway",Font.BOLD,20));
        City.setBounds(100,490,200,30);
        add(City);
        city1 = new JTextField();
        city1.setFont(new Font("Raleway",Font.BOLD,14));
        city1.setBounds(300,490,400,30);
        add(city1);
        
        // State
        JLabel State = new JLabel("State: ");
        State.setFont(new Font("Raleway",Font.BOLD,20));
        State.setBounds(100,540,200,30);
        add(State);
        state1 = new JTextField();
        state1.setFont(new Font("Raleway",Font.BOLD,14));
        state1.setBounds(300,540,400,30);
        add(state1);
        

        
        // Pin
        JLabel Pin = new JLabel("Pin Code: ");
        Pin.setFont(new Font("Raleway",Font.BOLD,20));
        Pin.setBounds(100,590,200,30);
        add(Pin);
        pin = new JTextField();
        pin.setFont(new Font("Raleway",Font.BOLD,14));
        pin.setBounds(300,590,400,30);
        add(pin);
        
        // Button
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        
        
         
        
       setSize(850,800);
       setLocation(350,10);
       setVisible(true);
       getContentPane().setBackground(Color.WHITE);
    }
    
    public void actionPerformed(ActionEvent ac)
    {
        String formno ="" + random;
        String name = name1.getText();
        String fname = father1.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();

        String gender = null;
        if(male.isSelected()) {gender = "Male"; }
        else if(female.isSelected()) { gender = "Female"; }
        
        String email = email1.getText();
        String marital = null;
        if(married.isSelected()) { marital = "Married"; }
        else if(unmarried.isSelected()) { marital = "Unmarried"; }
        else if(other.isSelected()) { marital = "Other"; }
        
        String address = add.getText();
        String city = city1.getText();
        String state = state1.getText();
        String Pin = pin.getText();
        
        try
        {
            if(name.equals(""))
            {
               JOptionPane.showMessageDialog(null, "Name is Required!00");
            }
            else
            {
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+state+"', '"+Pin+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        }
         catch(Exception e)
        {
            System.out.print(e);
        }
    }
    public static void main(String args[])
    {

        new SignOne();
    }

}
