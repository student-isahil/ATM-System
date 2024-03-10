package bank.management.system1;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener {

 
    JComboBox religion1,category1,income1,education1, occupation1; 
    JTextField pan1,Aadhar1;
    JButton next;
    JRadioButton Citizen1,Citizen2,Existing1,Existing2;
    String formno;
    
    SignupTwo(String formno)
    {
        this.formno = formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        
        JLabel personal = new JLabel("Page 2: Additional Details");
        personal.setBounds(290,80,400,30);
        personal.setFont(new Font("Raleway",Font.BOLD,22));
        add(personal);
        
        // religion
        JLabel religion = new JLabel("Religion: ");
        religion.setBounds(100,140,100,30);
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        add(religion);
        
        String a[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religion1 = new JComboBox(a);
        religion1.setBounds(300,140,400,30);
        religion1.setBackground(Color.WHITE);
        add(religion1);
        
        // Category
        JLabel category = new JLabel("Category: ");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(100,190,200,30);
        add( category);
        
        String b[] = {"GENERAL","OBC","SC"};
        category1 = new JComboBox(b);
        category1.setBackground(Color.WHITE);
        category1.setBounds(300,190,400,30);
        add(category1);
        
        // Income
        JLabel income = new JLabel("Income: ");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(100,240,200,30);
        add(income);
        
        String c[] = {"Null","< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
        income1 = new JComboBox(c);
        income1.setBounds(300,240,400,30);
        income1.setBackground(Color.WHITE);
        add(income1);


        // Educational Qualification
        JLabel education = new JLabel("Qualification: ");
        education.setFont(new Font("Raleway",Font.BOLD,20));
        education.setBounds(100,290,200,30);
        add(education);
        
        String d[] = {"Non Graduation", "Graduate", "Post Graduate", "Doctrate", "Other"};
        education1 = new JComboBox(d);
        education1.setBounds(300,290,400,30);
        education1.setBackground(Color.WHITE);
        add(education1);

        // Occupation
        JLabel occupation = new JLabel("Occupation: ");
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setBounds(100,340,200,30);
        add(occupation);
        
        String e[] = {"Saldried" , "Self-Employed", "Bussiness", "Student", "Retired", "Other"};
        occupation1 = new JComboBox(e);
        occupation1.setFont(new Font("Raleway",Font.BOLD,14));
        occupation1.setBounds(300,340,400,30);
        add(occupation1);
        
        //PAN Number
        JLabel pan = new JLabel("PAN Number: ");
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(100,390,200,30);
        add(pan);
        pan1 = new JTextField();
        pan1.setBounds(300,390,400,30);
        pan1.setBackground(Color.WHITE);
        pan1.setFont(new Font("Raleway",Font.BOLD,14));
        add(pan1);
 
        // Aadhar Number
        JLabel  Aadhar = new JLabel(" Aadhar Number: ");
        Aadhar.setFont(new Font("Raleway",Font.BOLD,20));
        Aadhar.setBounds(100,440,200,30);
        add( Aadhar);
        Aadhar1 = new JTextField();
        Aadhar1.setFont(new Font("Raleway",Font.BOLD,14));
        Aadhar1.setBounds(300,440,400,30);
        add( Aadhar1);
        
        // Senior Citizen
        JLabel Citizen = new JLabel("Senior Citizen: ");
        Citizen.setFont(new Font("Raleway",Font.BOLD,20));
        Citizen.setBounds(100,490,200,30);
        add(Citizen);
        Citizen1 = new JRadioButton("Yes");
        Citizen1.setBackground(Color.WHITE);
        Citizen1.setBounds(300,490,120,30);
        add(Citizen1);
                
        Citizen2 = new JRadioButton("NO");
        Citizen2.setBackground(Color.WHITE);
        Citizen2.setBounds(450,490,120,30);
        add(Citizen2);
        
        ButtonGroup z = new ButtonGroup();
        z.add(Citizen1);
        z.add(Citizen2);
        
        // Existing Account
        JLabel Existing = new JLabel("Existing Account: ");
        Existing.setFont(new Font("Raleway",Font.BOLD,20));
        Existing.setBounds(100,540,200,30);
        add(Existing);
       Existing1 = new JRadioButton("Yes");
       Existing1.setBackground(Color.WHITE);
       Existing1.setBounds(300,540,120,30);
       add(Existing1);
       Existing2 = new JRadioButton("No");
       Existing2.setBackground(Color.WHITE);
       Existing2.setBounds(450,540,120,30);
       add(Existing2);
       
        ButtonGroup k = new ButtonGroup();
        k.add(Existing1);
        k.add(Existing2);
        
        
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
        String religion = (String) religion1.getSelectedItem();
        String category = (String)category1.getSelectedItem();
        String income =   (String)income1.getSelectedItem();
        String qualification = (String)education1.getSelectedItem();
        String occupation = (String)occupation1.getSelectedItem();
        String pan = pan1.getText();
        String aadhar = Aadhar1.getText();
        String citizen = null;
        if(Citizen1.isSelected()) citizen = "Yes";
        else if(Citizen2.isSelected()) citizen = "No";
        
        String account = null;
        if(Existing1.isSelected()) account = "Yes";
        else if(Existing2.isSelected()) account = "No";
        
        try
        {
                Conn c = new Conn();
                String query = "insert into signupTwo values('"+formno+"', '"+religion+"', '"+category+"', '"+income+"', '"+qualification+"', '"+occupation+"', '"+pan+"', '"+aadhar+"', '"+citizen+"', '"+account+"')";
                c.s.executeUpdate(query);
                
                // signupthree ka code
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            
        }
         catch(Exception e)
        {
            System.out.print(e);
        }
    }
    public static void main(String args[])
    {

        new SignupTwo("");
    }

}
