
package javaapplication5;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class login extends JFrame implements ActionListener{
    JTextField tfusername,tfpass;
    login()
    {
       getContentPane().setBackground(Color.WHITE);
      setLayout(null);
      
      JLabel username = new JLabel("Username");
      username.setBounds(40, 20, 100, 30);
      add(username);
      
       tfusername = new JTextField();
      tfusername.setBounds(150, 20, 150, 30);
      add(tfusername);
      
      JLabel password = new JLabel("Password");
      password.setBounds(40, 70, 100, 30);
      add(password);
      
       tfpass = new JTextField();
      tfpass.setBounds(150, 70, 150, 30);
      add(tfpass);
      
    ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/member.jpg"));
      Image i2= i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
      ImageIcon i3= new ImageIcon(i2);
      JLabel image= new JLabel(i3);
      image.setBounds(20, 40, 900, 100);
      add(image);
      
      
    JButton login = new JButton("Log in");
    login.setBounds(150, 140, 150, 30);
    login.setBackground(Color.BLUE);
    login.setForeground(Color.WHITE);
    login.setFont(new Font("serif",Font.PLAIN,20));
    login.addActionListener(this);
    add(login);
      
      setSize(600,300);
      setLocation(456,200); 
      setVisible(true);
      
    }
    
    
   public void actionPerformed(ActionEvent ae) {
       try{
           String username = tfusername.getText();
           String password = tfpass.getText();
           
           conn c = new conn();
           String query = "select * from login where username = '"+username+"'and password = '"+password+"'";
           ResultSet rs = c.s.executeQuery(query);
           if(rs.next())
           {
              setVisible(false); 
              new home();
           }
           else
           {
               JOptionPane.showMessageDialog(null,"Invalid password or username");
               setVisible(false);
           }
       }
       catch (Exception e){
           e.printStackTrace();
       }
   }
    
    public static void main(String[] args) {
        new login();
    }
}

