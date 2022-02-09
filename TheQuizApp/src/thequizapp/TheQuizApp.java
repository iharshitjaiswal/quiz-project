package thequizapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TheQuizApp extends JFrame implements ActionListener
{
    JButton b1,b2;
    JTextField t1;
    TheQuizApp()
    {
        setBounds(300,200,1325,500);
        getContentPane().setBackground(Color.WHITE); 
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("TQA2.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0,0,800,470);
        add(l1); 
        
        JLabel l2 = new JLabel ("THE QUIZ APP ");
        l2.setBounds(900,40,300,50);
        l2.setFont(new Font("Arial",Font.BOLD,39));
        l2.setForeground(new Color(10,150,255));
        add(l2);
        
        JLabel l3 =new JLabel("  ENTER YOUR NAME");
        l3.setFont(new Font("Times New Roman",Font.ITALIC,22));
        l3.setForeground(Color.MAGENTA);
        l3.setBounds(930,190,300,50);
        add(l3);
      
        t1 = new JTextField();
        t1.setBounds(890,245,310,30);
        t1.setFont(new Font("Times New Roman", Font.BOLD,20));
        add(t1);
        setLayout(null);
        
        b1 = new JButton("START GAME");
        b1.setBounds(890,300,110,30);
        b1.setBackground(new Color(30,144,255));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("EXIT");
        b2.setBounds(1090,300,110,29);
        b2.setBackground(new Color(30,144,255));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        setVisible(true);    
    }   
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1){
            String name = t1.getText();
            this.setVisible(false);
            new Rules(name);
        }
        else
        {
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        new TheQuizApp();
    }   
}
