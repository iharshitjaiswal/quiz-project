package thequizapp;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class score extends JFrame implements ActionListener{
    JButton b1,b2;
   score(String username, int score){
        
        setBounds(600,150,750,600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("score.jfif"));
        JLabel l1 =new JLabel(i1);
        l1.setBounds(0,0,750,240);
        add(l1);
        
      JLabel l2 = new JLabel("Thanyou " + username + " for playing on The Quiz App");
        l2.setBounds(60,130,650,300);
        l2.setForeground(Color.cyan);
        l2.setFont(new Font("RALEWAY", Font.PLAIN,28));
        add(l2);
        
        JLabel l3 = new JLabel("Your Score is " + score);
        l3.setBounds(60,190,650,300);
        l3.setFont(new Font("Times New Roman", Font.PLAIN,26));
        l3.setForeground(Color.magenta);
        add(l3);
      
        
        b2 = new JButton("Exit");
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.WHITE);
        b2.setBounds(550,440,130, 35);
        b2.addActionListener(this);
        add(b2);
      
    }
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==b2){
          
           System.exit(0);}
       }
    public static void main(String[] args) {
        new score("", 0).setVisible(true);
    }
}
