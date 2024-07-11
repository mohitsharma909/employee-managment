
package javaapplication5;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ViewEmp extends JFrame implements ActionListener{
    JTable table;
    Choice empname;
    JButton searchy,print,update,back;
    ViewEmp(){
        
        
      getContentPane().setBackground(Color.WHITE);
      setLayout(null);
      setSize(900,700);
      setLocation(300,50); 
      setVisible(true);
      
      JLabel search = new JLabel("Search by Name");
       search.setBounds(20,20,150,20);
       search.setFont(new Font("serif",Font.PLAIN,20));
       add(search);
       
       empname = new Choice();
       empname.setBounds(180,20,150,30);
       add(empname);
       
      searchy = new JButton("Search");
    searchy.setBounds(20, 70, 100, 20);
    searchy.setBackground(Color.YELLOW);
    searchy.setForeground(Color.BLACK);
    searchy.setFont(new Font("serif",Font.PLAIN,18));
    searchy.addActionListener(this);
    add(searchy);
       
    
    print = new JButton("Print");
    print.setBounds(120, 70, 100, 20);
    print.setBackground(Color.YELLOW);
    print.setForeground(Color.BLACK);
    print.setFont(new Font("serif",Font.PLAIN,18));
    print.addActionListener(this);
    add(print);
    
    update = new JButton("Update");
    update.setBounds(220, 70, 100, 20);
    update.setBackground(Color.YELLOW);
    update.setForeground(Color.BLACK);
    update.setFont(new Font("serif",Font.PLAIN,18));
    update.addActionListener(this);
    add(update);
    
    back = new JButton("Back");
    back.setBounds(320, 70, 100, 20);
    back.setBackground(Color.YELLOW);
    back.setForeground(Color.BLACK);
    back.setFont(new Font("serif",Font.PLAIN,18));
    back.addActionListener(this);
    add(back);
    
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
      try{
         conn con = new conn();
       ResultSet rs = con.s.executeQuery("select * from employee");
       while(rs.next()){
           empname.add(rs.getString("name"));
       }
         }
       catch (Exception e)
       {
          e.printStackTrace();
       } 
       
       
      
      table = new JTable();
       try{
         conn con = new conn();
       ResultSet rs = con.s.executeQuery("select * from employee");
       table.setModel(DbUtils.resultSetToTableModel(rs));
         }
       catch (Exception e)
       {
          e.printStackTrace();
       }
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        
        
       
       
    }
    
    public void actionPerformed(ActionEvent ae)
    {
     if(ae.getSource()==searchy)   
     {
       String query= "select * from employee where name = '"+empname.getSelectedItem()+"'";
       
       try{
        conn c = new conn();
        ResultSet rs = c.s.executeQuery(query);
       table.setModel(DbUtils.resultSetToTableModel(rs));
        
       }
       catch (Exception e){
          e.printStackTrace();
       }
     }
     else if(ae.getSource()==print)
     {
         try{
        table.print();
       }
       catch (Exception e){
          e.printStackTrace();
       }
     }
     else if(ae.getSource()==update)
     {   setVisible(false);
         new update(empname.getSelectedItem());
         
     }
     else
     {
         setVisible(false);
         new home();
     }
    }
    
    
   public static void main(String[] args) {
        new ViewEmp();
    } 
}
