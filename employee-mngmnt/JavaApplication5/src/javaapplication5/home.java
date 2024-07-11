package javaapplication5;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;



public class home extends JFrame implements ActionListener  {
    JButton add,view,update,remove;
    home(){
        setLayout(null);
        
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
       Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
       ImageIcon i3= new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(0,0,1120,630);
       add(image); 
       
       JLabel heading = new JLabel("Employee Management System");
       heading.setBounds(550,20,400,40);
       heading.setFont(new Font("serif",Font.BOLD,30));
       image.add(heading);
       
     add = new JButton("Add New Employees");
    add.setBounds(550, 80, 150, 40);
    add.addActionListener(this);
    image.add(add);
    
     view = new JButton("View Employees");
    view.setBounds(720, 80, 150, 40);
    view.addActionListener(this);
    image.add(view);
    
    update = new JButton("Update Employees");
    update.setBounds(550, 140, 150, 40);
    update.addActionListener(this);
    image.add(update);
    
    
    remove = new JButton("Remove Employees");
    remove.setBounds(720, 140, 150, 40);
    remove.addActionListener(this);
    image.add(remove);  
       
       
       
       
        
      setSize(1120,630);
      setLocation(220,100); //Opening on laptop screen
      setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae)
    {
      if (ae.getSource()==add)
      {
         setVisible(false);
         new addemp();   
      }
      else if(ae.getSource()==view)
      {
          setVisible(false);
         new ViewEmp();   
      }
      else if(ae.getSource()==update)
      { 
          setVisible(false);
          new ViewEmp();
      }
      else
      {
        setVisible(false);
          new remove();  
      }
    }
    
    public static void main(String[] args) {
        new home();
    }
    
}
