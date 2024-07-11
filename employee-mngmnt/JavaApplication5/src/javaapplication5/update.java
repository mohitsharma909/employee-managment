
package javaapplication5;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.*;
import net.proteanit.sql.DbUtils;


public class update extends JFrame implements ActionListener{
    
    JButton clickhere2,clickhere;
    JTextField eedu,prole,sal,eemail,ephone;
    String empname;
    JLabel tfname;
    
     update(String empname){
         this.empname = empname;
         setLayout(null);
         
      JLabel heading = new JLabel("Update Employee Details");
       heading.setBounds(120,30,500,50);
       heading.setFont(new Font("serif",Font.BOLD,35));
       add(heading);   
         
       JLabel name = new JLabel("Name");
       name.setBounds(50,150,150,30);
       name.setFont(new Font("serif",Font.PLAIN,20));
       add(name);
       tfname = new JLabel();
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
       JLabel birth = new JLabel();
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
       JLabel eaad = new JLabel();
       eaad.setBounds(170,300,200,30);
       add(eaad);
       
       
       JLabel edu = new JLabel("Education");
       edu.setBounds(450,300,150,30);
       edu.setFont(new Font("serif",Font.PLAIN,20));
       add(edu);
       eedu = new JTextField();
       eedu.setBounds(550,300,250,30);
       add(eedu);
       
       String query= "select * from employee where name = '"+empname+"'";
   try{
        conn c = new conn();
        ResultSet rs = c.s.executeQuery(query); 
        while(rs.next())
        {
            tfname.setText(rs.getString("name"));
            sal.setText(rs.getString("pack"));
            birth.setText(rs.getString("dob"));
            eaad.setText(rs.getString("aadhar"));
            eedu.setText(rs.getString("edu"));
            ephone.setText(rs.getString("mobile"));
            eemail.setText(rs.getString("mail"));
            prole.setText(rs.getString("role"));


            
        }
       }
       catch (Exception e){
          e.printStackTrace();
       }    
       
       
       
       
       
       
       
    clickhere = new JButton("Update");
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
       String role=prole.getText();
       String pack=sal.getText();
       String mail=eemail.getText();
       String mobile=ephone.getText();
       String edu= (String) eedu.getText();
       
         try{
         conn con = new conn();
String query = "update employee set role= '"+role+"',pack='"+pack+"',mail='"+mail+"',mobile='"+mobile+"',edu='"+edu+"' where name='"+empname+"'";
       con.s.executeUpdate(query);
       JOptionPane.showMessageDialog(null, "Details Updated Successfully!!!");
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
        new update("");
    }
}

