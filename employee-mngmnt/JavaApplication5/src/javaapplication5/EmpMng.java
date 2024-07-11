
package javaapplication5;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class EmpMng extends JFrame implements ActionListener {

    EmpMng()
    { 
       setLayout(null) ;
       
       
       
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
       Image i2 = i1.getImage().getScaledInstance(1170, 650, Image.SCALE_DEFAULT);
       ImageIcon i3= new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(0,0,1170,650);
       add(image);
       JLabel heading = new JLabel("Wells-Fargo Management System");
       heading.setBounds(150,30,1200,90);
      heading.setForeground(Color.WHITE);
       heading.setFont(new Font("serif",Font.PLAIN,70));
       image.add(heading);
      
    
    JButton clickhere = new JButton("Click Here to Continue");
    clickhere.setBounds(400, 400, 300, 70);
    clickhere.setBackground(Color.BLACK);
    clickhere.setForeground(Color.WHITE);
    clickhere.setFont(new Font("roman_baseline",Font.PLAIN,20));
    clickhere.addActionListener(this);
    add(clickhere);
    
       
      getContentPane().setBackground(Color.red);
      setSize(1170,650);
      setLocation(220,50); //Opening on laptop screen
      setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
      setVisible(false) ;
      new login();
    }
    
     public static void main(String[] args) {
        new EmpMng();
    }
}

