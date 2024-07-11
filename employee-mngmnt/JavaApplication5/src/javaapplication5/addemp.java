package javaapplication5;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;


public class addemp extends JFrame implements ActionListener{
    
    JButton clickhere2,clickhere;
    JTextField tfname,prole,sal,eemail,ephone,eaad;
    JDateChooser birth;
    JComboBox eedu;
    
    
     addemp(){
         setLayout(null);
         
      JLabel heading = new JLabel("Add Employees");
       heading.setBounds(320,30,500,50);
       heading.setFont(new Font("serif",Font.BOLD,35));
       add(heading);   
         
       JLabel name = new JLabel("Name");
       name.setBounds(50,150,150,30);
       name.setFont(new Font("serif",Font.PLAIN,20));
       add(name);
        tfname = new JTextField();
       tfname.setBounds(170,150,200,30);
       add(tfname);
         
       JLabel role = new JLabel("Role");
       role.setBounds(450,150,150,30);
       role.setFont(new Font("serif",Font.PLAIN,20));
       add(role);
       prole = new JTextField();
       prole.setBounds(550,150,200,30);
       add(prole);
       
       JLabel dob = new JLabel("Date of Birth");
       dob.setBounds(50,200,150,30);
       dob.setFont(new Font("serif",Font.PLAIN,20));
       add(dob);
       birth = new JDateChooser();
       birth.setBounds(170,200,200,30);
       add(birth);
       
       
       JLabel salary = new JLabel("Package");
       salary.setBounds(450,200,150,30);
       salary.setFont(new Font("serif",Font.PLAIN,20));
       add(salary);
        sal = new JTextField();
       sal.setBounds(550,200,250,30);
       add(sal);
       
       JLabel email = new JLabel("Email");
       email.setBounds(450,250,150,30);
       email.setFont(new Font("serif",Font.PLAIN,20));
       add(email);
        eemail = new JTextField();
       eemail.setBounds(550,250,250,30);
       add(eemail);
       
       
       JLabel phone = new JLabel("Phone");
       phone.setBounds(50,250,150,30);
       phone.setFont(new Font("serif",Font.PLAIN,20));
       add(phone);
        ephone = new JTextField();
       ephone.setBounds(170,250,200,30);
       add(ephone);
       
       
       JLabel aad = new JLabel("Aadhar");
       aad.setBounds(50,300,150,30);
       aad.setFont(new Font("serif",Font.PLAIN,20));
       add(aad);
       eaad = new JTextField();
       eaad.setBounds(170,300,200,30);
       add(eaad);
       
       
       JLabel edu = new JLabel("Education");
       edu.setBounds(450,300,150,30);
       edu.setFont(new Font("serif",Font.PLAIN,20));
       add(edu);
       String course[]={"B.Tech","M.Tech","MCA","M.Sc"};
       eedu = new JComboBox(course);
       eedu.setBounds(550,300,250,30);
       add(eedu);
       
    clickhere = new JButton("Add");
    clickhere.setBounds(200, 450, 150, 50);
    clickhere.setBackground(Color.GREEN);
    clickhere.setForeground(Color.WHITE);
    clickhere.setFont(new Font("serif",Font.PLAIN,20));
    clickhere.addActionListener(this);
    add(clickhere);
    
    clickhere2 = new JButton("Back");
    clickhere2.setBounds(500, 450, 150, 50);
    clickhere2.setBackground(Color.RED);
    clickhere2.setForeground(Color.WHITE);
    clickhere2.setFont(new Font("serif",Font.PLAIN,20));
    clickhere2.addActionListener(this);
    add(clickhere2);
    
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
         
         
      getContentPane().setBackground(Color.WHITE);
      setSize(900,700);
      setLocation(300,50); //Opening on laptop screen
      setVisible(true);
     }
     
    public void actionPerformed(ActionEvent ae)
    {
     if(ae.getSource()==clickhere)
     {
       String name=tfname.getText();
       String role=prole.getText();
       String pack=sal.getText();
       String dob=((JTextField)birth.getDateEditor().getUiComponent()).getText();
       String mail=eemail.getText();
       String mobile=ephone.getText();
       String aadhar=eaad.getText();
       String edu= (String) eedu.getSelectedItem();
       
         try{
         conn con = new conn();
String query = "insert into employee (name,role,pack,dob,mail,mobile,aadhar,edu) values('"+name+"','"+role+"','"+pack+"','"+dob+"','"+mail+"','"+mobile+"','"+aadhar+"','"+edu+"')";
       con.s.executeUpdate(query);
       JOptionPane.showMessageDialog(null, "Details Added Successfully!!!");
       setVisible(false);
         new home();  
         }
       catch (Exception e)
       {
          e.printStackTrace();
       }
       
     }
     else
     {
       setVisible(false);
         new home();  
     }
    } 
     
     
     
    
    public static void main(String[] args) {
        new addemp();
    }
}
