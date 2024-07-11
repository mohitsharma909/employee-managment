package javaapplication5;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.sql.*;
import java.sql.DriverManager;
import java.util.*;

public class remove extends JFrame implements ActionListener{
    Choice empname;
    JButton delete,back;
    
   remove() {
    getContentPane().setBackground(Color.WHITE);  
      setLayout(null);
       
       JLabel search = new JLabel("Search by Name");
       search.setBounds(50,50,150,30);
       search.setFont(new Font("serif",Font.PLAIN,20));
       add(search);
       
       empname = new Choice();
       empname.setBounds(200,50,150,30);
       add(empname);
       
       try{
          conn c = new conn();
          String query= "select * from employee";
          ResultSet rs= c.s.executeQuery(query);
          
          while(rs.next())
          {
              empname.add(rs.getString("name"));
          }
       }
       catch (Exception e){
           e.printStackTrace();
       }

   JLabel labelname = new JLabel("Name");
   labelname.setBounds(50, 100, 100, 30);
   add(labelname);
   
   JLabel lblname = new JLabel();
   lblname.setBounds(200, 100, 100, 30);
   add(lblname);
   
   JLabel labelphone = new JLabel("Phone");
   labelphone.setBounds(50, 150, 100, 30);
   add(labelphone);
   
   JLabel lblph = new JLabel();
   lblph.setBounds(200, 150, 100, 30);
   add(lblph);
   
   JLabel labelemail = new JLabel("Email");
   labelemail.setBounds(50, 200, 100, 30);
   add(labelemail);
   
   JLabel lbemail = new JLabel();
   lbemail.setBounds(200, 200, 100, 30);
   add(lbemail);
   
   try{
          conn c = new conn();
          String query= "select * from employee where name = '"+empname.getSelectedItem()+"'";
          ResultSet rs= c.s.executeQuery(query);
          
          while(rs.next())
          {
              lblname.setText(rs.getString("name"));
              lblph.setText(rs.getString("mobile"));
              lbemail.setText(rs.getString("mail"));
          }
       }
       catch (Exception e){
           e.printStackTrace();
       }
   
      empname.addItemListener(new ItemListener(){
         public void itemStateChanged(ItemEvent ie)
         {
            try{
          conn c = new conn();
          String query= "select * from employee where name = '"+empname.getSelectedItem()+"'";
          ResultSet rs= c.s.executeQuery(query);
          
          while(rs.next())
          {
              lblname.setText(rs.getString("name"));
              lblph.setText(rs.getString("mobile"));
              lbemail.setText(rs.getString("mail"));
          }
       }
       catch (Exception e){
           e.printStackTrace();
       } 
         }
      });
   
    delete = new JButton("Delete");
    delete.setBounds(80, 300, 100, 30);
    delete.setBackground(Color.red);
    delete.setForeground(Color.WHITE);
    delete.addActionListener(this);
    add(delete);
    
    back = new JButton("Back");
    back.setBounds(220, 300, 100, 30);
    back.setBackground(Color.black);
    back.setForeground(Color.WHITE);
    back.addActionListener(this);
    add(back);
    
     ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/delt.jpg")) ;
     Image i2= i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
     ImageIcon i3 = new ImageIcon(i2);
     JLabel image = new JLabel(i3);
     image.setBounds(350, 0, 600, 400);
     add(image);
     
      
  setSize(1000,400);
      setLocation(300,150); 
      setVisible(true); 
   }
   public void actionPerformed(ActionEvent ae)  
   {
     if (ae.getSource()== delete)  
     {
        try{
           conn c = new conn();
          String query= "delete from employee where name = '"+empname.getSelectedItem()+"'";
          c.s.executeUpdate(query);
          JOptionPane.showMessageDialog(null, "Employee removed successfully");
          setVisible(false);
          new home();
        } 
        catch (Exception e){
           e.printStackTrace();
       } 
     }
     else
     {
         setVisible(false);
         new home();
     }
   }
    public static void main(String[] args)
    {
        new remove();
    }
}
